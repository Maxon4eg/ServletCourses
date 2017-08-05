package com.akhambir.dao;

import com.akhambir.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    public User getUser(User user) {
        String getUserQuery = "SELECT USERNAME, PASSWORD, TOKEN,  EMAIL FROM USERS WHERE TOKEN = ? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getUserQuery);

            preparedStatement.setString(1, user.getToken());
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            resultSet.next();
            User resultUser = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            preparedStatement.close();
            return resultUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User create(User user) {
        try {
//            Statement statement = connection.createStatement();
//            String query = "INSERT INTO USERS (USERNAME, TOKEN, PASSWORD, EMAIL) " +
//                    "VALUES( \'" + user.getUserName() + "\', \'"
//                    +user.getToken()+"\', \'"+
//                    user.getPassword()+"\', \'"+user.getEmail()+"\')";
//            statement.execute(query);

            PreparedStatement preparedStatement;
            String preparedQuery = "INSERT INTO USERS (USERNAME, TOKEN, PASSWORD, EMAIL) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(preparedQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getToken());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.execute();
//            preparedStatement.
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public User findByToken(String token) {
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
