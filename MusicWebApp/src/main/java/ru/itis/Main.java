package ru.itis;

import ru.itis.dao.Dao;
import ru.itis.dao.impl.ArticleDaoImpl;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.service.ArticleService;
import ru.itis.service.UserService;
import ru.itis.service.impl.ArticleServiceImpl;
import ru.itis.service.impl.UserServiceImpl;
import ru.itis.util.PasswordUtil;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User("a","aw","af","fsa");
        ArticleService articleService = new ArticleServiceImpl();
        Dao<Article> articleDao = new ArticleDaoImpl();
        Article article = new Article(2,"Animal Collective ", "https://www.youtube.com/watch?v=WU60gQMTHJY&ab_channel=Be", "Animal Collective have canceled a European tour that was due to start next month", "rock");
        articleService.save(article);
        System.out.println(articleDao.get(7));

    }
}
