package ru.itis.util.validator;

import ru.itis.models.Forum;

public class ForumValidator {
    public boolean forumVerification(Forum forum) {
        String forumHeader = forum.getForumHeader();
        String login = forum.getUserLogin();
        return forumHeader.trim().length() != 0 && login.trim().length() != 0;
    }
}
