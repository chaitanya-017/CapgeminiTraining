package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_config_1 {

    private static final String URL = "jdbc:mysql://localhost:3306/crud";
    private static final String USER = "root";
    private static final String PASSWORD = "Capg@1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}