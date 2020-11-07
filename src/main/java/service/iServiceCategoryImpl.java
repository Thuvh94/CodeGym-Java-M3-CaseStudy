package service;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class iServiceCategoryImpl implements iService<Category> {
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String FIND_CATEGORY_BY_ID = "select * from category where categoryId= ?;";

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
    public void add(Category object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void update(int id, Category object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Connection connection = new Connection();
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int categoryId = resultSet.getInt("categoryId");
            String categoryName = resultSet.getString("categoryName");
            category = new Category(categoryId,categoryName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return category;

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
