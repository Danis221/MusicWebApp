package ru.itis.service.impl;

import ru.itis.dao.Dao;
import ru.itis.dao.PostDao;
import ru.itis.dao.impl.PostDaoImpl;


import ru.itis.dto.PostDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    private final PostDao postDao = new PostDaoImpl();
    @Override
    public PostDto get(int id) {
        Post p = postDao.get(id);
        return new PostDto(p.getPostContent(), p.getCreated(), p.getUserLogin());
    }

    @Override
    public List<PostDto> getAll() {

        return postDao.getAll().stream().map(
                p -> new PostDto( p.getPostContent(), p.getCreated(), p.getUserLogin())
        ).collect(Collectors.toList());
    }

    @Override
    public void save(Post post) {
         postDao.save(post);
    }

    @Override
    public void update(Post post) {
        postDao.save(post);
    }

    @Override
    public List<PostDto> getAllByForumId(int forumId) {

        return postDao.getAllByForumId(forumId).stream().map(
                p -> new PostDto(p.getPostContent(), p.getCreated(), p.getUserLogin())
        ).collect(Collectors.toList());
    }

    @Override
    public boolean postVerification(Post post) {
       String posContent = post.getPostContent();
        return posContent != null && posContent.trim().length() !=0;
    }

    public void createPost(Post post) {
        this.save(post);
    }


}
