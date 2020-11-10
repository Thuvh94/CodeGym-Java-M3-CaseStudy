package service;

import model.Category;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeServiceImpl implements RecipeService{
    private static final String SELECT_ALL_RECIPE = "select * from recipe";
    private static final String FIND_RECIPE_BY_ID = "select * from recipe where recipeId= ?;";
    private static final String DELETE_RECIPE = "delete from recipe where recipeId = ?;";


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
            CategoryServiceImpl categoryImpl = new CategoryServiceImpl();
            Category category = categoryImpl.findById(categoryId);
            Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
            Timestamp createdAt = resultSet.getTimestamp("createdAt");
            int writerId = resultSet.getInt("writerId");
            recipeList.add(new Recipe( recipeId, title, description, ingredient, difficulty, cookTime,yield,category, publishedAt, createdAt,writerId)) ;
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
        callableStatement.setString("coverImg", "noImage"); // Để test tạm
        int row = callableStatement.executeUpdate();
        System.out.println(row);
        callableStatement.close();
    }

    @Override
    public void update(int id, Recipe object) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        CallableStatement callableStatement = connection.getConnection().prepareCall("{ call updateRecipe(?,?,?,?,?,?,?,?,?)}");
        callableStatement.setInt("inputId",id);
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
        callableStatement.close();
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new Connection();
        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE_RECIPE);
        preparedStatement.setInt(1,id);
        int row = preparedStatement.executeUpdate();
        System.out.println(row);
        preparedStatement.close();
    }

    @Override
    public Recipe findById(int id) {
        Recipe recipe = null;
        Connection connection = new Connection();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(FIND_RECIPE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String ingredient = resultSet.getString("ingredient");
                int difficulty = resultSet.getInt("difficulty");
                float cookTime = resultSet.getFloat("cookTime");
                int yield = resultSet.getInt("yield");
                int categoryId = resultSet.getInt("categoryId");
                CategoryServiceImpl categoryImpl = new CategoryServiceImpl();
                Category category = categoryImpl.findById(categoryId);
                Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                String coverImg = resultSet.getString("coverImg");
                int writerId = resultSet.getInt("writerId");
                recipe = new Recipe( id, title, description, ingredient, difficulty, cookTime,yield,category, publishedAt, createdAt, coverImg, writerId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public List<Recipe> findByCategory(Category category) {
        List<Recipe> recipeList = new ArrayList<>();
        Connection connection = new Connection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.getConnection().prepareCall("{ call findRecipeByCategory(?)}");
            callableStatement.setInt(1,category.getCategoryId());
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int recipeId = resultSet.getInt("recipeId");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String ingredient = resultSet.getString("ingredient");
                int difficulty = resultSet.getInt("difficulty");
                float cookTime = resultSet.getFloat("cookTime");
                int yield = resultSet.getInt("yield");
//                int categoryId = resultSet.getInt("categoryId");
                Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                String coverImg = resultSet.getString("coverImg");
                int writerId = resultSet.getInt("writerId");
                recipeList.add(new Recipe( recipeId, title, description, ingredient, difficulty, cookTime,yield,category, publishedAt, createdAt,coverImg,writerId)) ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return recipeList;
    }
    @Override
    public List<Recipe> findByName(String name){
        List<Recipe> recipeList = new ArrayList<>();
        Connection connection = new Connection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.getConnection().prepareCall("{ call searchByName(?)}");
            callableStatement.setString(1,name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int recipeId = resultSet.getInt("recipeId");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String ingredient = resultSet.getString("ingredient");
                int difficulty = resultSet.getInt("difficulty");
                float cookTime = resultSet.getFloat("cookTime");
                int yield = resultSet.getInt("yield");
                int categoryId = resultSet.getInt("categoryId");
                CategoryServiceImpl categoryImpl = new CategoryServiceImpl();
                Category category = categoryImpl.findById(categoryId);
                Timestamp publishedAt = resultSet.getTimestamp("publishedAt");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                int writerId = resultSet.getInt("writerId");
                recipeList.add(new Recipe( recipeId, title, description, ingredient, difficulty, cookTime,yield,category, publishedAt, createdAt,writerId)) ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

}
