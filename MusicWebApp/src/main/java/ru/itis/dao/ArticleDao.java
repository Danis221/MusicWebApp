package ru.itis.dao;

import ru.itis.models.Article;

import java.util.List;

public interface ArticleDao extends Dao<Article>{

    List<Article> getAllWhereGenre(String genre);
}
