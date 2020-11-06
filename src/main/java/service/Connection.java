package service;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/customers?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Thuvh2508!";

    protected java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        java.sql.Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }
}
