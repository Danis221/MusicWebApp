package ru.itis.service.impl;

import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.dto.UserDto;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getFirstName(), u.getLastName(), u.getLogin())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        User u = userDao.get(id);
        return new UserDto(u.getFirstName(), u.getLastName(), u.getLogin());
    }


    @Override
    public void save(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public UserDto get(String login) {
        User u = userDao.get(login);
        return new UserDto(u.getFirstName(), u.getLastName(), u.getLogin());
    }

    @Override
    public void update(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userDao.update(user);
    }

    public boolean authentication (User user) {
        User existsUserWithLogin = userDao.get(user.getLogin());

        if(existsUserWithLogin == null) {
            save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean userVerificationForLogin(String enteredLogin, String enteredPassword) {
        String encryptPassword = PasswordUtil.encrypt(enteredPassword);
        User tempUser = userDao.get(enteredLogin);
        if (tempUser!= null) { //проверям что юссер с введеным логином существует
            String password = tempUser.getPassword();
            return password.equals(encryptPassword);
        }
        return false;
    }

    @Override
    public boolean userVerification(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getFirstName();
        String password = user.getPassword();
        return firstName.trim().length() != 0 && lastName.trim().length() != 0 && password.trim().length() != 0;
    }
}
