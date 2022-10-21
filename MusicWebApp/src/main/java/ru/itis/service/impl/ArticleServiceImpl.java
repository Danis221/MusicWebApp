package ru.itis.service.impl;

import ru.itis.dao.ArticleDao;
import ru.itis.dao.Dao;
import ru.itis.dao.UserDao;
import ru.itis.dao.impl.ArticleDaoImpl;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao = new ArticleDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<Article> getAll() {
        return articleDao.getAll();
    }

    @Override
    public Article get(int id) {
        return articleDao.get(id);
    }

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<Article> getArticlesWhereGenre(String genre) {
        return articleDao.getAllWhereGenre(genre);
    }
    @Override
    public void createArticle(Article article) {
        if (articleVerification(article)) {
            this.save(article);
        }
    }
    @Override
    public boolean articleVerification(Article article) {
        String name = article.getName();
        String videoFromYouTube = article.getVideoFromYouTube();
        String text = article.getText();
        String genre = article.getGenre();
        String userID = article.getUserLogin();
        return name.trim().length() != 0 && videoFromYouTube.trim().length() != 0 && text.trim().length() != 0 && genre.trim().length() != 0 && userID.trim().length() != 0;
    }
}
