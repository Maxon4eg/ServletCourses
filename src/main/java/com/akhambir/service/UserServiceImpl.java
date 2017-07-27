package com.akhambir.service;

import com.akhambir.dao.UserDao;
import com.akhambir.model.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
}