package ru.itis.servlet;

import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.Forum;
import ru.itis.models.User;
import ru.itis.service.ForumService;
import ru.itis.service.impl.ForumServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "forumServlet", urlPatterns = "/forum")
public class ForumServlet extends HttpServlet {
    private final ForumService forumService = new ForumServiceImpl();
    private final UserDao userDao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("forum", forumService.getAll());
        req.getRequestDispatcher("forum.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String forumHeader = req.getParameter("forumHeader");

        long now = System.currentTimeMillis();
        Date sqlDate = new Date(now);

        Forum form = new Forum(forumHeader, sqlDate,login);
        if (forumService.forumVerification(form)) {
            forumService.createForum(form);
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("error", "not working");
            req.getRequestDispatcher("forum.ftl").forward(req, resp);
        }

    }
}
