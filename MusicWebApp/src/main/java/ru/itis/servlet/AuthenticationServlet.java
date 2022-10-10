package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "authenticationServlet", urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final Dao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("auth.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String password = req.getParameter("password");

        User existsUserWithLogin = userDao.get(login);

        if(existsUserWithLogin == null) {
            userService.save(new User(login, firstName, lastName, password));
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("error", "this login already exists");
            req.getRequestDispatcher("auth.ftl").forward(req, resp);
        }
    }
}
