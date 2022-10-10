package ru.itis;

import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.impl.UserServiceImpl;
import ru.itis.util.PasswordUtil;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User("Denis", "asdf", "123", "123");
        UserService userService = new UserServiceImpl();
       //userService.save(user);
      //  System.out.println(userDao.get("123").getLogin());
        System.out.println(userDao.get("123").getPassword());
        String l = "asdf";
        String p = PasswordUtil.encrypt( l);
        System.out.println(PasswordUtil.encrypt("123"));

//        System.out.println(l + "   " + p);
//
//        System.out.println(p.equals(userDao.get("asdf").getPassword()));
//        System.out.println(userDao.get("asdf").getPassword().equals(p));

    }
}
