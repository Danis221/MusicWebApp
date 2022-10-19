package ru.itis.dao;

import ru.itis.models.Event;

import java.sql.Date;
import java.util.List;

public interface EventDao extends Dao<Event>{
     List<Event> getAllBySettings(Date startDate, Date endDate, Integer price);
}
