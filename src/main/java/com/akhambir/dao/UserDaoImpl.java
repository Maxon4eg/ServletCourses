package com.akhambir.dao;

import com.akhambir.model.User;

import java.util.HashSet;

import java.util.Set;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final Set<User> userList = new HashSet<>();

    static {
        userList.add(new User("Vova", "123123"));
        userList.add(new User("Vova2", "123123"));
        userList.add(new User("Anton", "123123"));
    }

    public User getUser(User user) {
        if (userList.contains(user)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
