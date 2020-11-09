package service;

import model.Category;
import model.CookStep;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class iServiceCookStep implements CookStepService {
        private static final String SELECT_ALL_COOKSTEP = "select * from cookstep where recipeId=?";
//    private static final String DELETE_COOKSTEP = "delete from cookstep where cookStepId = ?;";

//    @Override
//    public List<CookStep> findAll() throws SQLException, ClassNotFoundException {
//        List<CookStep> cookStepList = new ArrayList<>();
//        Connection connection = new Connection();
//        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_ALL_COOKSTEP);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            int cookStepId = resultSet.getInt("cookStepId");
//            int recipeId = resultSet.getInt("recipeId");
//            String textContent = resultSet.getString("textContent");
//            iServiceRecipeImpl serviceRecipe = new iServiceRecipeImpl();
//            Recipe recipe = serviceRecipe.findById(recipeId);
//            cookStepList.add(new CookStep(cookStepId,recipe,textContent));
//        }
//        return cookStepList;
//    }

    @Override
    public List<CookStep> findAllByRecipeId(Recipe recipe) throws SQLException, ClassNotFoundException {
        List<CookStep> cookStepList = new ArrayList<>();
        Connection connection = new Connection();
        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(SELECT_ALL_COOKSTEP);
        preparedStatement.setInt(1,recipe.getRecipeId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int cookStepId = resultSet.getInt("cookStepId");
            String textContent = resultSet.getString("textContent");
            iServiceRecipeImpl serviceRecipe = new iServiceRecipeImpl();
            cookStepList.add(new CookStep(cookStepId,recipe,textContent));
        }
        return cookStepList;
    }

    @Override
    public void add(CookStep object) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call addCookStep(?,?)}");
        Recipe recipe = object.getRecipeId();
        callableStatement.setInt("recipeId",recipe.getRecipeId());
        callableStatement.setString("textContent",object.getTextContent());
        int row = callableStatement.executeUpdate();
        System.out.println(row);
    }

    @Override
    public void update(Recipe recipe, CookStep object) throws SQLException, ClassNotFoundException {

    }

//    @Override
//    public void delete(Recipe recipe) throws SQLException, ClassNotFoundException {
//
//    }

//    @Override
//    public CookStep findById(int id) {
//        return null;
//    }

//    @Override
//    public void update(int id, CookStep object) throws SQLException, ClassNotFoundException {
//        Connection connection = new Connection();
//        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call updateCookStep(?,?,?)}");
//        callableStatement.setInt("cookStepId",id);
//        Recipe recipe = object.getRecipeId();
//        callableStatement.setInt("recipeId",recipe.getRecipeId());
//        callableStatement.setString("textContent",object.getTextContent());
//        int row = callableStatement.executeUpdate();
//        System.out.println(row);
//    }

//    @Override
//    public void delete(int id) throws SQLException, ClassNotFoundException {
//        Connection connection = new Connection();
//        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_COOKSTEP);
//        preparedStatement.setInt(1,id);
//        int row = preparedStatement.executeUpdate();
//        System.out.println(row);
//    }

//    @Override
//    public CookStep findById(int id) {
//        return null;
//    }
}
