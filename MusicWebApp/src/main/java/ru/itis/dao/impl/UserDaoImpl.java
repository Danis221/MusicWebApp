package ru.itis.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.dao.Dao;
import ru.itis.models.User;
import ru.itis.util.PostgresConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserDaoImpl implements Dao<User> {

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS = "select * from users;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from users where id = ?";

    private static final String SQL_SAVE = "INSERT into users (login,first_name, last_name, password) VALUES (?, ?, ?, ?);";

    //language=SQL
    public static final String SQL_SELECT_BY_LOGIN = "select * from users where login = ?";


    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionUtil.getConnection();

    private static final Function<ResultSet, User> userMapper = resultSet -> {
        try {
            return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("login"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public User get(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return userMapper.apply(resultSet);
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
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = userMapper.apply(resultSet);
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }
    }

    @Override
    public void save(User user) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    @Override
    public User get(String login) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_LOGIN);
            statement.setString(1, login);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return userMapper.apply(resultSet);
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
            return null;
        }
    }

}
