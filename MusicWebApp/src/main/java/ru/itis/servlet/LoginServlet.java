package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;
import ru.itis.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String enteredLogin = req.getParameter("login");
        String enteredPassword = req.getParameter("password");
        String rememberMe = req.getParameter("_remember_me");


        if (userService.userVerification(enteredLogin, enteredPassword)) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("login", enteredLogin);
            httpSession.setMaxInactiveInterval(60 * 60);

            if (rememberMe != null) {
                Cookie httpCookie = new Cookie("username", enteredLogin);
                httpCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(httpCookie);
            }
            resp.setContentType("text/html;charset=UTF-8");
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", "Invalid login or password");
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }
    }


}
