package service;

import model.Category;
import model.CookStep;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class iServiceCookStep implements iService<CookStep> {
    private static final String SELECT_ALL_COOKSTEP = "select * from cookstep";

    @Override
    public List<CookStep> findAll() throws SQLException, ClassNotFoundException {
        List<CookStep> cookStepList = new ArrayList<>();
        Connection connection = new Connection();
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_COOKSTEP);
        while (resultSet.next()){
            int cookStepId = resultSet.getInt("cookStepId");
            int recipeId = resultSet.getInt("recipeId");
            String textContent = resultSet.getString("textContent");
            iServiceRecipeImpl serviceRecipe = new iServiceRecipeImpl();
            Recipe recipe = serviceRecipe.findById(recipeId);
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
    public void update(int id, CookStep object) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call updateCookStep(?,?,?)}");
        callableStatement.setInt("cookStepId",id);
        Recipe recipe = object.getRecipeId();
        callableStatement.setInt("recipeId",recipe.getRecipeId());
        callableStatement.setString("textContent",object.getTextContent());
        int row = callableStatement.executeUpdate();
        System.out.println(row);
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
//        Connection connection = new Connection();
//        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_COOKSTEP);
//        preparedStatement.setInt(1,id);
//        int row = preparedStatement.executeUpdate();
//        System.out.println(row);
    }

    @Override
    public CookStep findById(int id) {
        return null;
    }
}
