package ru.itis.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.dao.PostDao;
import ru.itis.models.Article;
import ru.itis.models.Post;
import ru.itis.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PostDaoImpl implements PostDao {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from post;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from post where post_id = ?";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into post (post_content, created, form_id, user_login) VALUES (?, ?, ?, ?);";

    //language=SQL
    public static final String SQL_UPDATE = "UPDATE post SET  post_content = ?, created = ?, form_id = ?, user_login = ? where post_id = ?;";

    //language=SQL
    private static final String SQL_GET_ALL_WHERE_FORUM_ID = "SELECT * from post where form_id=?;";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private final Connection connection = PostgresConnectionUtil.getConnection();

    private static final Function<ResultSet, Post> postMapper = resultSet -> {
        try {
            return new Post(
                    resultSet.getInt("post_id"),
                    resultSet.getString("post_content"),
                    resultSet.getDate("created"),
                    resultSet.getInt("form_id"),
                    resultSet.getString("user_login"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };


    @Override
    public Post get(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return postMapper.apply(resultSet);
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
            return null;
        }
    }

    @Override
    public List<Post> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            List<Post> posts = new ArrayList<>();


            while (resultSet.next()) {
                Post post = postMapper.apply(resultSet);
                posts.add(post);
            }

            return posts;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }

    }

    @Override
    public void save(Post post) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE);

            preparedStatement.setString(1, post.getPostContent());
            preparedStatement.setDate(2, post.getCreated());
            preparedStatement.setInt(3, post.getFormId());
            preparedStatement.setString(4, post.getUserLogin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    @Override
    public void update(Post post) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1, post.getPostContent());
            preparedStatement.setDate(2, post.getCreated());
            preparedStatement.setInt(3, post.getFormId());
            preparedStatement.setString(4, post.getUserLogin());
            preparedStatement.setInt(5, post.getPostId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getAllByForumId(int forumId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_WHERE_FORUM_ID);
            statement.setInt(1, forumId);


            try (ResultSet resultSet = statement.executeQuery()) {
                List<Post> posts = new ArrayList<>();
                while (resultSet.next()) {
                    Post post = postMapper.apply(resultSet);
                    posts.add(post);
                }
                return posts;
            }
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }

    }

}
