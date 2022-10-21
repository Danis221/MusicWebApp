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
    public boolean forumVerification(Forum forum) {
        String forumHeader = forum.getForumHeader();
        String login = forum.getUserLogin();
        return forumHeader.trim().length() != 0 && login.trim().length() != 0;
    }

    @Override
    public void createForum(Forum forum) {
        this.save(forum);
    }
}
