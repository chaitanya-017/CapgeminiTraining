package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class Operations {
    public static void addProduct(int product_id,String product_name,String category,double price,int quantity,float rating,String manufacturer) throws SQLException{
        String query = "INSERT INTO products VALUES(product_id,product_name,category,price,quantity,rating,manufacturer)" ;
        Connection conn = db_config_1.getConnection();
        Statement statement = conn.createStatement();
        int rowInserted = 0;
        if(rowInserted>0){
            System.out.println(rowInserted+"row inserted");
        }
        else{
            System.out.println("insert failed");
        }
    }
    public static void display(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("empno");
            String name = rs.getString("ename");
            System.out.println(id + " " + name);
        }
    }
    public static void main(String[] args) throws SQLException {

    }
}
