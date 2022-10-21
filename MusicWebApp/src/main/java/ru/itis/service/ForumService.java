package ru.itis.service;

import ru.itis.dao.Dao;
import ru.itis.models.Forum;
import ru.itis.models.Post;

public interface ForumService extends Dao<Forum> {
    boolean forumVerification(Forum forum);
    void createForum(Forum forum);
}
