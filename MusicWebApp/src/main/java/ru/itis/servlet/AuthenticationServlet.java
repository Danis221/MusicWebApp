package ru.itis.servlet;


import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;
import ru.itis.util.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "authenticationServlet", urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final UserValidator userValidator = new UserValidator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("auth.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String password = req.getParameter("password");

        User user = new User(login, firstName, lastName, password);
        if(userValidator.userVerification(user)) {
            userService.save(user);
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("error", "this login already exists");
            req.getRequestDispatcher("auth.ftl").forward(req, resp);
        }
    }
}
