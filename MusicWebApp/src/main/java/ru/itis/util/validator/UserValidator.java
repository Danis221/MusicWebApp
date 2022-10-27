package ru.itis.util.validator;

import ru.itis.dao.UserDao;
import ru.itis.dao.impl.UserDaoImpl;
import ru.itis.models.User;
import ru.itis.util.PasswordUtil;

public class UserValidator {

    private final UserDao userDao = new UserDaoImpl();

    public boolean userVerificationForLogin(String enteredLogin, String enteredPassword) {
        String encryptPassword = PasswordUtil.encrypt(enteredPassword);
        User tempUser = userDao.get(enteredLogin);
        if (tempUser != null) { //проверям что юссер с введеным логином существует
            String password = tempUser.getPassword();
            return password.equals(encryptPassword);
        }
        return false;
    }


    public boolean userVerification(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getFirstName();
        String password = user.getPassword();
        return firstName.trim().length() != 0 && lastName.trim().length() != 0 && password.trim().length() != 0;
    }
}
