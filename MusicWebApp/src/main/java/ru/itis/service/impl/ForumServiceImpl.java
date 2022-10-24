package ru.itis.service.impl;

import ru.itis.dao.ForumDao;
import ru.itis.dao.impl.ForumDaoImpl;
import ru.itis.models.Forum;
import ru.itis.service.ForumService;

import java.util.List;

public class ForumServiceImpl implements ForumService {
    private final ForumDao forumDao = new ForumDaoImpl();
    @Override
    public Forum get(int id) {
        return forumDao.get(id);
    }

    @Override
    public List<Forum> getAll() {
        return forumDao.getAll();
    }

    @Override
    public void save(Forum forum) {
        forumDao.save(forum);
    }

    @Override
    public void update(Forum forum) {
        forumDao.update(forum);
    }

    @Override
    public void createForum(Forum forum) {
        this.save(forum);
    }
}
