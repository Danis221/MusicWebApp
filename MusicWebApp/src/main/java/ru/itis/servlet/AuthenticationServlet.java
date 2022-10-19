package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;
import ru.itis.util.UserImageUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "authenticationServlet", urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final UserImageUtil userImageUtil = new UserImageUtil();
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
//        Part part = req.getPart("file");

//        String image = userImageUtil.saveImageOnCloudinary(part);

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
