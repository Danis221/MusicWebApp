package ru.itis.servlet;

import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateProfileServlet", urlPatterns = "/updateProfile")
public class updateProfileServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("updateProfile.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String password = req.getParameter("password");
        String login = (String) session.getAttribute("login");

        System.out.println(login);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(password);

        if (firstName.trim().length() != 0 && lastName.trim().length() != 0 && password.trim().length() != 0) {
            User updateUser = new User(login, firstName, lastName, password);
            userService.update(updateUser);
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("error", "something is not filled");
            resp.sendRedirect("/updateProfile");
        }
    }
}
