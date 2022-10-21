package ru.itis.models;

public class Article {
    private int articleId;

    private final String userLogin;
    private final String name;
    private final String videoFromYouTube;
    private final String text;
    private final String genre;

    public Article(int articleId, String userLogin, String name, String videoFromYouTube, String text, String genre) {
        this.userLogin = userLogin;
        this.articleId = articleId;
        this.name = name;
        this.videoFromYouTube = videoFromYouTube;
        this.text = text;
        this.genre = genre;
    }

    public Article(String userLogin, String name, String videoFromYouTube, String text, String genre) {
        this.userLogin = userLogin;
        this.name = name;
        this.text = text;
        this.videoFromYouTube = videoFromYouTube;
        this.genre = genre;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getName() {
        return name;
    }

    public String getVideoFromYouTube() {
        return videoFromYouTube;
    }

    public String getText() {
        return text;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getGenre() {
        return genre;
    }

}
