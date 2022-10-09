package ru.itis.service;

import ru.itis.dto.UserDto;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAll();

    UserDto get(int id);

    void save(User user);
}
