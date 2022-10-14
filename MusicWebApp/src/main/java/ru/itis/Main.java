package ru.itis;

import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User(1, "login", "Adeel", "Churka", "jkljaslk");
        System.out.println(userService.get(1));

        userService.update(user);
        System.out.println(userService.get(1));
    }
}
