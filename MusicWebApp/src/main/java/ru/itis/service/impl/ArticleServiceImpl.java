package ru.itis.service.impl;

import ru.itis.dao.ArticleDao;
import ru.itis.dao.Dao;
import ru.itis.dao.impl.ArticleDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao = new ArticleDaoImpl();


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
}
