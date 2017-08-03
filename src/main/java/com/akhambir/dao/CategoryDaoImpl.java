package com.akhambir.dao;

import com.akhambir.model.Category;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    private static List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category(1L, "Shoes", null));
        categoryList.add(new Category(2L, "Dresses", null));
        categoryList.add(new Category(3L, "Pants", null));
    }

    public CategoryDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category delete(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return CategoryDaoImpl.categoryList;
    }
}
