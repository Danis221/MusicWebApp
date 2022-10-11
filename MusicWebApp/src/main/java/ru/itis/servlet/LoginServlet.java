package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final Dao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String enteredLogin = req.getParameter("login");
        String enteredPassword = req.getParameter("password");
        String rememberMe = req.getParameter("_remember_me");

        String encryptPassword = PasswordUtil.encrypt(enteredPassword);

        User tempUser = userDao.get(enteredLogin);
        if (tempUser != null) {
            String login = tempUser.getLogin();
            String password = tempUser.getPassword();

            if (enteredLogin.equals(login) && password.equals(encryptPassword)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                if (rememberMe.equals("on")) {
                    Cookie httpCookie = new Cookie("username", login);
                    httpCookie.setMaxAge(24 * 60 * 60);
                    resp.addCookie(httpCookie);
                }
                resp.sendRedirect("/");
            } else {
                req.setAttribute("error", "Invalid login or password");
                req.getRequestDispatcher("login.ftl").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "User with this login does not exist");
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }

    }
}
