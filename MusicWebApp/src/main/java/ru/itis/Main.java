package ru.itis;

import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User("Denis", "asdf", "aa", "aa");
        UserService userService = new UserServiceImpl();
        //userService.save(user);
        System.out.println(userDao.get("login"));
        //System.out.println(userService.getAll());

    }
}
