package ru.itis.service.impl;

import ru.itis.dao.EventDao;
import ru.itis.dao.impl.EventDaoImpl;
import ru.itis.models.Event;
import ru.itis.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    private final EventDao eventDao = new EventDaoImpl();
    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public Event get(int id) {
        return eventDao.get(id);
    }

    @Override
    public void save(Event event) {
        eventDao.save(event);
    }
}
