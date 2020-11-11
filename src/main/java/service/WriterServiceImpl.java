package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriterServiceImpl implements IWriterService{
    @Override
    public boolean checkLogin(String name, String password) {
        boolean isValid = false;
        Connection connection = new Connection();
        String sql = "select * from writer where writerName = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                isValid = true;
            }
            else isValid = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  isValid;
    }
}
