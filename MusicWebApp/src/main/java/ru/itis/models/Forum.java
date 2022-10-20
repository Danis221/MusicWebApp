package ru.itis.models;

import java.sql.Date;

public class Forum {

    private int forumId;

    private final String forumHeader;
    private final Date created;
    private final String login;

    public Forum(int forumId, String forumHeader, Date created, String login) {
        this.forumId = forumId;
        this.forumHeader = forumHeader;
        this.created = created;
        this.login = login;
    }

    public Forum(String forumHeader, Date created, String login) {
        this.forumHeader = forumHeader;
        this.created = created;
        this.login = login;
    }

    public int getForumId() {
        return forumId;
    }

    public String getForumHeader() {
        return forumHeader;
    }

    public Date getCreated() {
        return created;
    }

    public String getUserLogin() {
        return login;
    }
}
