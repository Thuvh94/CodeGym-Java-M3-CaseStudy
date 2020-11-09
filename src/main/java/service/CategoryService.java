package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    List<Category> findAll() throws SQLException, ClassNotFoundException;
    void add(Category object) throws SQLException, ClassNotFoundException;
    void update (int id, Category object) throws SQLException, ClassNotFoundException;
    void delete(int id) throws SQLException, ClassNotFoundException;
    Category findById (int id);
}
