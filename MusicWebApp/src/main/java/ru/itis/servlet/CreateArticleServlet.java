package ru.itis.servlet;

import ru.itis.dao.Dao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.ArticleService;
import ru.itis.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "createArticlesServlet", urlPatterns = "/createArticle")
public class CreateArticleServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();
    private final Dao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("createArticle.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");

        String name = req.getParameter("name");
        String videoFromYouTube = req.getParameter("videoFromYouTube");
        String text = req.getParameter("text");
        String genre = req.getParameter("genre");

        User user = userDao.get(login);
        if ((name != null || !name.equals("")) && (videoFromYouTube != null || !videoFromYouTube.equals("")) && (text != null || !text.equals("")) && (genre != null || !genre.equals("")))
        {
            Article newArticle = new Article(user.getId(), name, videoFromYouTube, text, genre);

            articleService.save(newArticle);
            resp.sendRedirect("/");

        } else {
            resp.sendRedirect("/createArticle");
        }


    }
}
