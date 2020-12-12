package service;

import pojo.User;

import java.util.List;

public interface UserService {
    void addUser(String account, String password, int type);

    int signIn(String account, String password);
}
