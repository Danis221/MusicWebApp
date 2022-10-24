package ru.itis.util.validator;

import ru.itis.models.Article;

public class ArticleValidator {

    public boolean articleVerification(Article article) {
        String name = article.getName();
        String videoFromYouTube = article.getVideoFromYouTube();
        String text = article.getText();
        String genre = article.getGenre();
        String userID = article.getUserLogin();
        return name.trim().length() != 0 && videoFromYouTube.trim().length() != 0 && text.trim().length() != 0 && genre.trim().length() != 0 && userID.trim().length() != 0;
    }
}
