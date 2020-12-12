package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    User findUserByAccount(String account);

    void addUser(String account, String password, int type);

    void deleteUser(String account);

    List<User> getAllUser();

    int signIn(String account, String password);
}
