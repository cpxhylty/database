package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();


    @Override
    public void addUser(String account, String password, int type) {
        userDao.addUser(account, password, type);
    }

    @Override
    public int signIn(String account, String password) {
        return userDao.signIn(account, password);
    }
}
