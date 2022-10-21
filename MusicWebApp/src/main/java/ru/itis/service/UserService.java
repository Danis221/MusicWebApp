package ru.itis.service;

import ru.itis.dto.UserDto;
import ru.itis.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto get(int id);

    void save(User user);

    UserDto get(String login);

    void update(User user);

    boolean authentication (User user);
    boolean userVerification(String enteredLogin, String enteredPassword);
}
