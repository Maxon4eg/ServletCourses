package com.akhambir.dao;

import com.akhambir.model.Category;

import java.util.List;

public interface CategoryDao extends GenericDao<Category> {

    List<Category> getAll();
}
