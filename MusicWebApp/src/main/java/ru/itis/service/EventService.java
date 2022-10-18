package ru.itis.service;

import ru.itis.models.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event get(int id);

    void save(Event Event);

}
