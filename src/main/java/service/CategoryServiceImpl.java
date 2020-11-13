package service;

import model.Category;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String FIND_CATEGORY_BY_ID = "select * from category where categoryId= ?;";
    private static final String ADD_CATEGORY = "insert into category (categoryName) values (?);";
    private static final String DELETE_CATEGORY ="delete from category where categoryId = ?;";
    private static final String COUNT_RECIPE_BY_CATEGORY = "select count(categoryId) from recipe where categoryId = ?;";

    @Override
    public List<Category> findAll() throws SQLException, ClassNotFoundException {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = new Connection();
        try (Statement statement = connection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORY);
            while (resultSet.next()) {
                int id = resultSet.getInt("categoryId");
                String name = resultSet.getString("categoryName");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }


    @Override
    public void add(String name)  {
        Connection connection = new Connection();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(ADD_CATEGORY);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String name){
        Connection connection = new Connection();
        try {
            CallableStatement callableStatement = connection.getConnection().prepareCall("{ call updateCategory(?,?)}");
            callableStatement.setInt(1,id);
            callableStatement.setString(2,name);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id){
        Connection connection = new Connection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(DELETE_CATEGORY);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            printSQLException(throwables);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Connection connection = new Connection();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int categoryId = resultSet.getInt("categoryId");
                String categoryName = resultSet.getString("categoryName");
                category = new Category(categoryId,categoryName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return category;

    }

    @Override
    public int countRecipeByCategoryId(int id) {
        Connection connection = new Connection();
        PreparedStatement preparedStatement = null;
        int number = 0;
        try {
            preparedStatement = connection.getConnection().prepareStatement(COUNT_RECIPE_BY_CATEGORY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                number = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return number;
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

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
