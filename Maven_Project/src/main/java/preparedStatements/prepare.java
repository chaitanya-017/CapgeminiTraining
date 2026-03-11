package preparedStatements;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prepare {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","Capg@1234");
        String sql = "INSERT INTO emp VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        // Setting values
        ps.setInt(1, 1234);
        ps.setString(2, "Sanidhya");
        ps.setString(3, "Engineer");
        ps.setInt(4, 7698);
        ps.setDate(5, java.sql.Date.valueOf("1981-02-20"));
        ps.setDouble(6, 1600.00);
        ps.setDouble(7, 300.00);
        ps.setInt(8, 30);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Employee inserted successfully!");
        else
            System.out.println("Insert failed!");
    }
}
