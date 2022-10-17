package ru.itis.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.dao.ArticleDao;
import ru.itis.dao.Dao;
import ru.itis.models.Article;
import ru.itis.models.User;
import ru.itis.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ArticleDaoImpl implements ArticleDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from articles ORDER BY article_id DESC;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from articles where article_id = ?";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into articles (user_id, name, video, text, genre ) VALUES(?, ?, ?, ?, ?);";

    //language=SQL
    public static final String SQL_SELECT_ALL_WHERE_GENRE = "select * from articles where genre = ?;";

    public static final String SQL_UPDATE = "UPDATE article SET  user_id = ?, name = ?, video = ?, text = ?, genre = ?  where article_id = ?;";

    private final Connection connection = PostgresConnectionUtil.getConnection();

    private static final Function<ResultSet, Article> articleMapper = resultSet -> {
        try {
            return new Article(
                    resultSet.getInt("article_id"),
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("video"),
                    resultSet.getString("text"),
                    resultSet.getString("genre"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public Article get(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return articleMapper.apply(resultSet);
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
    public List<Article> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                Article article = articleMapper.apply(resultSet);
                articles.add(article);
            }

            return articles;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }
    }

    @Override
    public void save(Article article) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE);
            preparedStatement.setInt(1, article.getUserId());
            preparedStatement.setString(2, article.getName());
            preparedStatement.setString(3, article.getVideoFromYouTube());
            preparedStatement.setString(4, article.getText());
            preparedStatement.setString(5, article.getGenre());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    @Override
    public void update(Article article) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);

            statement.setInt(1, article.getUserId());
            statement.setString(2, article.getName());
            statement.setString(3, article.getVideoFromYouTube());
            statement.setString(4, article.getText());
            statement.setString(5, article.getGenre());

            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Article> getAllWhereGenre(String genre) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_WHERE_GENRE);
            statement.setString(1, genre);


            try (ResultSet resultSet = statement.executeQuery()) {
                List<Article> articles = new ArrayList<>();
                while (resultSet.next()) {
                    Article article = articleMapper.apply(resultSet);
                    articles.add(article);
                }
                return articles;
            }
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }
    }
}
