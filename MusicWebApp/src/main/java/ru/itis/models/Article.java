package ru.itis.models;

public class Article {
    private int articleId;

    private int userId;
    private final String name;
    private final String videoFromYouTube;
    private final String text;
    private final String genre;

    public Article(int articleId, int userId, String name, String videoFromYouTube, String text, String genre) {
        this.articleId = articleId;
        this.articleId = articleId;
        this.name = name;
        this.videoFromYouTube = videoFromYouTube;
        this.text = text;
        this.genre = genre;
    }

    public Article(int userId, String name, String videoFromYouTube, String text, String genre) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", videoFromYouTube='" + videoFromYouTube + '\'' +
                ", text='" + text + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
