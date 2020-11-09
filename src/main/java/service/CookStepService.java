package service;

import model.CookStep;
import model.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface CookStepService{
    List<CookStep> findAll(Recipe recipe) throws SQLException, ClassNotFoundException;
    void add(CookStep object) throws SQLException, ClassNotFoundException;
    void update (Recipe recipe, CookStep object) throws SQLException, ClassNotFoundException;
    void delete(Recipe recipe) throws SQLException, ClassNotFoundException;
    CookStep findById (int id);
}
