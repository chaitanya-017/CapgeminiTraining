package org.example;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class db_config {
    public static void print(ResultSet rs) throws SQLException{
        while(rs.next()){
            int id = rs.getInt("empno");
            String name = rs.getString("ename");
            System.out.println(id+" "+name);
        }
    }
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","Capg@123");
        Statement statement = connection.createStatement();

//        int rowInserted = statement.executeUpdate("INSERT INTO users VALUES('9831','chaits','CHAUDHARY','5561','1982-01-23','1300.00',NULL,'10')");
//        System.out.println(rowInserted);
//        if(rowInserted>0){
//            System.out.println(rowInserted+"row inserted");
//        }
//        else{
//            System.out.println("insert failed");
//        }
        // ------------------------------------ update

//        int rowsUpdated = statement.executeUpdate("update users set ename='Omni Van' where empno = 9994");
//
//        if(rowsUpdated > 0) System.out.println(rowsUpdated+" rows updated");
//        else System.out.println("update failed");
//
//        ResultSet rs = statement.executeQuery("Select * from users");
//
//        print(rs);

        // ----------------------------------- delete

//        int rowsDeleted = statement.executeUpdate("delete from users where empno = 9994");
//
//        if(rowsDeleted > 0) System.out.println(rowsDeleted+" rows deleted");
//        else System.out.println("deletion failed");

        ResultSet rs = statement.executeQuery("select * from users");
        print(rs);

    }
}
