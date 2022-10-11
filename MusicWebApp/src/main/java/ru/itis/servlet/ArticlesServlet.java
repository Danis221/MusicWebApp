package ru.itis.servlet;


import ru.itis.service.ArticleService;
import ru.itis.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "articleServlet", urlPatterns = "/articles")
public class ArticlesServlet extends HttpServlet {

    private final ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("articles", articleService.getAll());
        req.getRequestDispatcher("articles.ftl").forward(req, resp);
    }
}
