package ru.itis.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.dao.ForumDao;
import ru.itis.models.Event;
import ru.itis.models.Forum;
import ru.itis.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ForumDaoImpl implements ForumDao {
    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from forum order by created desc;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from forum where forum_id = ?";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into forum (forum_header, created, user_login) VALUES (?, ?, ?);";

    //language=SQL
    public static final String SQL_UPDATE = "UPDATE forum SET  forum_header = ?, created = ?, user_login = ? where forum_id = ?;";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private final Connection connection = PostgresConnectionUtil.getConnection();

    private static final Function<ResultSet, Forum> forumMapper = resultSet -> {
        try {
            return new Forum(
                    resultSet.getInt("forum_id"),
                    resultSet.getString("forum_header"),
                    resultSet.getDate("created"),
                    resultSet.getString("user_login"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    @Override
    public Forum get(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return forumMapper.apply(resultSet);
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
    public List<Forum> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            List<Forum> forums = new ArrayList<>();


            while (resultSet.next()) {
                Forum forum = forumMapper.apply(resultSet);
                forums.add(forum);
            }

            return forums;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }
    }

    @Override
    public void save(Forum forum) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE);

            preparedStatement.setString(1, forum.getForumHeader());
            preparedStatement.setDate(2, forum.getCreated());
            preparedStatement.setString(3, forum.getUserLogin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }

    }

    @Override
    public void update(Forum forum) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);

            preparedStatement.setString(1, forum.getForumHeader());
            preparedStatement.setDate(2, forum.getCreated());
            preparedStatement.setString(3, forum.getUserLogin());
            preparedStatement.setInt(4,forum.getForumId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
