package ru.itis.dao;

import ru.itis.models.Post;

import java.util.List;

public interface PostDao extends Dao<Post>{
    List<Post> getAllByForumId(int forumId);
}
