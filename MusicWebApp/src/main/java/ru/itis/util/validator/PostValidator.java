package ru.itis.util.validator;

import ru.itis.models.Post;

public class PostValidator {

    public boolean postVerification(Post post) {
        String posContent = post.getPostContent();
        return posContent != null && posContent.trim().length() !=0;
    }
}
