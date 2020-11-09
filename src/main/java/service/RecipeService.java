package service;

import model.Category;
import model.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface RecipeService{
    List<Recipe> findAll() throws SQLException, ClassNotFoundException;
    void add(Recipe object) throws SQLException, ClassNotFoundException;
    void update (int id, Recipe object) throws SQLException, ClassNotFoundException;
    void delete(int id) throws SQLException, ClassNotFoundException;
    Recipe findById (int id);
    List<Recipe> findByCategory(Category category);
    List<Recipe> findByName(String name);
}
