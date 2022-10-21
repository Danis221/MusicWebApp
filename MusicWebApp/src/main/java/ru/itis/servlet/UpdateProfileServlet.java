package ru.itis.servlet;

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
public class UpdateProfileServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("updateProfile.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String password = req.getParameter("password");

        User updateUser = new User(login, firstName, lastName, password);
        if (userService.userVerification(updateUser)) {
            userService.update(updateUser);
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("error", "something is not filled");
            req.getRequestDispatcher("updateProfile.ftl").forward(req, resp);
        }
    }
}
