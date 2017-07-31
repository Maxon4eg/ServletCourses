package com.akhambir.factory;

import com.akhambir.controller.CreateUserController;
import com.akhambir.controller.GetAllCategoriesController;
import com.akhambir.dao.UserDaoImpl;
import com.akhambir.dao.CategoryDao;
import com.akhambir.dao.CategoryDaoImpl;
import com.akhambir.service.CategoryService;
import com.akhambir.service.CategoryServiceImpl;
import com.akhambir.service.UserService;
import com.akhambir.service.UserServiceImpl;

public class Factory {

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    public static UserDaoImpl getUserDao() {
        return new UserDaoImpl();
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(Factory.getCategoryService());
    }

    private static CategoryService getCategoryService() {
        return new CategoryServiceImpl(Factory.getCategoryDao());
    }

    private static CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    public static CreateUserController getCreateUserController() {
        return new CreateUserController(getUserService());
    }
}
