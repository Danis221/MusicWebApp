package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.util.PasswordUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final Dao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = PasswordUtil.encrypt(req.getParameter("password"));
        String rememberMe = req.getParameter("_remember_me");


        User tempUser = userDao.get(login);
        if (tempUser != null) {
            String enteredLogin = tempUser.getLogin();
            String enteredPassword = tempUser.getPassword();

            if (enteredLogin.equals(login) && enteredPassword.equals(password)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                if (rememberMe.equals("on")) {
                    Cookie httpCookie = new Cookie("username", login);
                    httpCookie.setMaxAge(24 * 60 * 60);
                    resp.addCookie(httpCookie);
                }
                resp.sendRedirect("/authentication");
            } else {
                resp.sendRedirect("/login");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}