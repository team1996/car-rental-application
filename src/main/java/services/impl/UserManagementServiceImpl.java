package services.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import services.UserManagementService;

import java.util.Optional;

public class UserManagementServiceImpl implements UserManagementService {

    private UserDao userDao;

    public UserManagementServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserByUserId(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public boolean isUserLoginExist(String login) {
        Optional<User> userByLogin = userDao.getUserByLogin(login);
        return userByLogin.isPresent();
    }

    @Override
    public boolean isUserValid(String login, String password) {
        Optional<User> user = userDao.getUserByLogin(login);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Optional<User> getUserByLogin(String userLogin) {
        return userDao.getUserByLogin(userLogin);
    }
}
