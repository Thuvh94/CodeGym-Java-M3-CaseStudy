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
            float cookTime = resultSet.getFloat("cookTime");
            int yield = resultSet.getInt("yield");
            int categoryId = resultSet.getInt("categoryId");
            iServiceCategoryImpl categoryImpl = new iServiceCategoryImpl();
            Category category = categoryImpl.findById(categoryId);
            Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
            Timestamp createdAt = resultSet.getTimestamp("createdAt");
            String coverImg = resultSet.getString("coverImg");
            int writerId = resultSet.getInt("writerId");
            recipeList.add(new Recipe( recipeId, title, description, ingredient, difficulty, cookTime,yield,category, publishedAt, createdAt, coverImg, writerId)) ;
        }
        return recipeList;
    }

    @Override
    public void add(Recipe object) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call addRecipe(?,?,?,?,?,?,?,?)}");
        callableStatement.setString("title",object.getTitle());
        callableStatement.setString("description",object.getDescription());
        callableStatement.setString("ingredient",object.getIngredient());
        callableStatement.setInt("difficulty",object.getDifficulty());
        callableStatement.setFloat("cookTime",object.getCookTime());
        callableStatement.setInt("yield",object.getYield());
        Category category = object.getCategoryId();
        callableStatement.setInt("categoryId",category.getCategoryId());
        callableStatement.setString("coverImg","No Image"); // Set tạm để Test
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
