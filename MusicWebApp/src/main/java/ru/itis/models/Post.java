package ru.itis.models;

import java.sql.Date;

public class Post {

    private int postId;

    private final String postContent;
    private final Date created;
    private final int formId;
    private final String userLogin;

    public Post(int postId, String postContent, Date created, int formId, String userLogin) {
        this.postId = postId;
        this.postContent = postContent;
        this.created = created;
        this.formId = formId;
        this.userLogin = userLogin;
    }

    public Post(String postContent, Date created, int formId, String userLogin) {
        this.postContent = postContent;
        this.created = created;
        this.formId = formId;
        this.userLogin = userLogin;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public Date getCreated() {
        return created;
    }

    public int getFormId() {
        return formId;
    }

    public String getUserLogin() {
        return userLogin;
    }
}
