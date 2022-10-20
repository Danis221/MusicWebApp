package ru.itis.dto;

import java.sql.Date;

public class PostDto {

    private String userLogin;
    private String postContent;
    private Date created;

    public PostDto( String postContent, Date created, String userLogin) {
        this.postContent = postContent;
        this.created = created;
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getPostContent() {
        return postContent;
    }

    public Date getCreated() {
        return created;
    }
}
