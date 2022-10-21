package ru.itis.servlet;

import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.ArticleService;
import ru.itis.service.UserService;
import ru.itis.service.impl.ArticleServiceImpl;
import ru.itis.service.impl.UserServiceImpl;

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
        Article newArticle = new Article(login, name, videoFromYouTube, text, genre);
        if (articleService.articleVerification(newArticle))
        {
            articleService.createArticle(newArticle);
            resp.sendRedirect("/");

        } else {
            req.setAttribute("error", "something is not filled");
            req.getRequestDispatcher("createArticle.ftl").forward(req, resp);
        }


    }
}
