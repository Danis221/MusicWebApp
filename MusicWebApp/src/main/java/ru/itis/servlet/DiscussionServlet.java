package ru.itis.servlet;

import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.Forum;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.service.ForumService;
import ru.itis.service.PostService;
import ru.itis.service.UserService;
import ru.itis.service.impl.ForumServiceImpl;
import ru.itis.service.impl.PostServiceImpl;
import ru.itis.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "discussionServlet", urlPatterns = "/discussion")
public class DiscussionServlet extends HttpServlet {

    private final ForumService forumService = new ForumServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final PostService postService = new PostServiceImpl();
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forumId = Integer.parseInt(req.getParameter("forumId"));
        UserDto userDto = userService.get(forumService.get(forumId).getUserLogin());


        req.setAttribute("discussion", forumService.get(forumId));
        req.setAttribute("user", userDto);
        req.setAttribute("forumId", forumId);
        req.setAttribute("posts", postService.getAllByForumId(forumId));
        req.getRequestDispatcher("discussion.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");


        String posContent = req.getParameter("posContent");
        String forumId = req.getParameter("forumId");


        long now = System.currentTimeMillis();
        Date sqlDate = new Date(now);

        Post post = new Post(posContent, sqlDate, Integer.parseInt(forumId), login);
        if ( postService.postVerification(post)) {
            postService.createPost(post);
            req.getRequestDispatcher("/").forward(req, resp);
        } else {
            req.setAttribute("error", "not working");
            req.getRequestDispatcher("forum.ftl").forward(req, resp);
        }


    }
}
