package service;

import model.Category;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class iServiceRecipeImpl implements iService<Recipe> {
    private static final String SELECT_ALL_RECIPE = "select * from recipe";
//    private static final String FIND_RECIPE_BY_ID = "select  "

    @Override
    public List<Recipe> findAll() throws SQLException, ClassNotFoundException {
        List<Recipe> recipeList = new ArrayList<>();
        Connection connection = new Connection();
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_RECIPE);
        while (resultSet.next()){
            int recipeId = resultSet.getInt("recipeId");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String ingredient = resultSet.getString("ingredient");
            int difficulty = resultSet.getInt("difficulty");
            float prepareTime = resultSet.getFloat("prepareTime");
            float cookTime = resultSet.getFloat("prepareTime");
            float waitingTime = resultSet.getFloat("waitingTime");
            int yield = resultSet.getInt("yield");
            String equipment = resultSet.getString("equipment");
            int categoryId = resultSet.getInt("categoryId");
            iServiceCategoryImpl categoryImpl = new iServiceCategoryImpl();
            Category category = categoryImpl.findById(categoryId);
            Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
            Timestamp createdAt = resultSet.getTimestamp("createdAt");
            Timestamp updatedAt = resultSet.getTimestamp("updatedAt");
            String coverImg = resultSet.getString("coverImg");
            int status = resultSet.getInt("status");
            int writerId = resultSet.getInt("writerId");
            recipeList.add(new Recipe( recipeId, title, description, ingredient, difficulty,
           prepareTime, cookTime,  waitingTime, yield,equipment,category,
                    publishedAt, createdAt, updatedAt, coverImg, status,
           writerId)) ;
        }
        return recipeList;
    }

    @Override
    public void add(Recipe object) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call addRecipe(?,?,?,?,?,?,?,?,?,?)}");
        callableStatement.setString(1,object.getTitle());
        callableStatement.setString(2,object.getDescription());
        callableStatement.setString(3,object.getIngredient());
        callableStatement.setInt(4,object.getDifficulty());
        callableStatement.setFloat(5,object.getPrepareTime());
        callableStatement.setFloat(6,object.getCookTime());
        callableStatement.setFloat(7,object.getWaitingTime());
        callableStatement.setInt(8,object.getYield());
        callableStatement.setInt(9,2); // tạm fix cứng để test chức năng add
        callableStatement.setString(10,object.getCoverImg());
        int row = callableStatement.executeUpdate();
        System.out.println(row);
    }

    @Override
    public void update(int id, Recipe object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Recipe findById(int id) {
        return null;
    }
}
