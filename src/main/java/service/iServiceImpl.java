package service;

import model.Recipe;

import java.sql.SQLException;
import java.util.List;

public class iServiceImpl implements iService<Recipe> {


    @Override
    public List<Recipe> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void add(Recipe object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void update(int id, Recipe object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

    }
}
