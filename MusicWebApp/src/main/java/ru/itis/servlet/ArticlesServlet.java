package ru.itis.servlet;


import ru.itis.service.ArticleService;
import ru.itis.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "articlesServlet", urlPatterns = "/articles")
public class ArticlesServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", articleService.getAll());
        req.getRequestDispatcher("articles.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String genreFilter = req.getParameter("genreFilter");

        if (genreFilter.equals("all")) {
            req.setAttribute("articles", articleService.getAll());
            req.getRequestDispatcher("articles.ftl").forward(req, resp);
        } else {
            req.setAttribute("articles", articleService.getArticlesWhereGenre(genreFilter));
            req.getRequestDispatcher("articles.ftl").forward(req, resp);
        }


    }


}
