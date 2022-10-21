package ru.itis.service;

import ru.itis.dao.Dao;

import ru.itis.dto.PostDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Post;

import java.util.List;

public interface PostService {

    PostDto get(int id);
    List<PostDto> getAll();
    public void save(Post post);

    public void update(Post post);

    List<PostDto> getAllByForumId(int forumId);

    boolean postVerification(Post post);

    void createPost(Post post);
}
