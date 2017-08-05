package com.akhambir.factory;

import com.akhambir.controller.Controller;
import com.akhambir.controller.CreateUserController;
import com.akhambir.controller.GetAllCategoriesController;
import com.akhambir.controller.HomeController;
import com.akhambir.dao.CategoryDao;
import com.akhambir.dao.CategoryDaoImpl;
import com.akhambir.dao.UserDaoImpl;
import com.akhambir.service.CategoryService;
import com.akhambir.service.CategoryServiceImpl;
import com.akhambir.service.UserService;
import com.akhambir.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDaoImpl getUserDao() {
        return new UserDaoImpl(getConnection());
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(Factory.getCategoryService());
    }

    private static CategoryService getCategoryService() {
        return new CategoryServiceImpl(Factory.getCategoryDao());
    }

    private static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl(getConnection());
    }

    public static CreateUserController getCreateUserController() {
        return new CreateUserController(getUserService());
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
        } catch (Exception e) {
            throw new RuntimeException("Driver was not initialized");
        }
        return connection;
    }

    public static Controller getHomeController() {
        return new HomeController();
    }

}
