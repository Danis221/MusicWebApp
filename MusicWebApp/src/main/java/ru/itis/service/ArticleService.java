package ru.itis.service;

import ru.itis.dao.impl.ArticleDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.Article;
import ru.itis.models.User;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    Article get(int id);

    void save(Article article);

    List<Article> getArticlesWhereGenre(String genre);

    void createArticle(Article article);



}
