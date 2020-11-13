package service;

import model.Category;
import model.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    List<Category> findAll() throws SQLException, ClassNotFoundException;

    //    void add(Category object) throws SQLException, ClassNotFoundException;
    void add(String name);

    //    void update (int id, Category object) throws SQLException, ClassNotFoundException;
    void update(int id, String name);

    void delete(int id);

    Category findById(int id);

    int countRecipeByCategoryId(int id);

    List<Recipe> findByCategory(Category category);
}
