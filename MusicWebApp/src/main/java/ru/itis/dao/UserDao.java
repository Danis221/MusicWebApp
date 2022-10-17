package ru.itis.dao;

import ru.itis.models.User;

public interface UserDao extends Dao<User> {
    User get(String value);
}
