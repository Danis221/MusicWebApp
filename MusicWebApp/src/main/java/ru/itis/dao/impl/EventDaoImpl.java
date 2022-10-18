package ru.itis.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itis.dao.EventDao;
import ru.itis.models.Article;
import ru.itis.models.Event;
import ru.itis.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EventDaoImpl implements EventDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from event order by concertDate;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from event where event_id = ?";

    //language=SQL
    private static final String SQL_SAVE = "INSERT into event (performer, concertDate, price, venue ) VALUES( ?, ?, ?, ?);";

    private static final String SQL_UPDATE = "UPDATE event SET   performer = ?, concertDate = ?, price = ?, venue = ?  where event_id = ?;";


    private final Connection connection = PostgresConnectionUtil.getConnection();

    private static final Function<ResultSet, Event> eventMapper = resultSet -> {
        try {
            return new Event(
                    resultSet.getInt("event_id"),
                    resultSet.getString("performer"),
                    resultSet.getString("concertDate"),
                    resultSet.getInt("price"),
                    resultSet.getString("venue"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public Event get(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return eventMapper.apply(resultSet);
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
    public List<Event> getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            List<Event> events = new ArrayList<>();

            while (resultSet.next()) {
                Event event = eventMapper.apply(resultSet);
                events.add(event);
            }

            return events;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return List.of();
        }
    }

    @Override
    public void save(Event event) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE);

            preparedStatement.setString(1, event.getPerformer());
            preparedStatement.setString(2, event.getConcertDate());
            preparedStatement.setInt(3, event.getPrice());
            preparedStatement.setString(4, event.getVenue());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    @Override
    public void update(Event event) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);

            statement.setString(1, event.getPerformer());
            statement.setString(2,  event.getConcertDate());
            statement.setInt(3, event.getPrice());
            statement.setString(4, event.getVenue());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
