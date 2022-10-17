package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);


}