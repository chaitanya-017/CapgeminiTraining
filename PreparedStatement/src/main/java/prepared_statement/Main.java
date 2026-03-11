package prepared_statement;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class Main {

    // ------------------- VIEW METHOD -------------------
    public static void viewEmployees(Connection conn) throws SQLException {

        String sql = "SELECT * FROM emp";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("EmpNo | Ename | Job | Mgr | Hiredate | Salary | Comm | DeptNo");
        System.out.println("---------------------------------------------------------------");

        while (rs.next()) {

            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            double sal = rs.getDouble("sal");
            double comm = rs.getDouble("comm");
            int deptno = rs.getInt("deptno");

            System.out.println(empno + " | " +
                    ename + " | " +
                    job + " | " +
                    mgr + " | " +
                    hiredate + " | " +
                    sal + " | " +
                    comm + " | " +
                    deptno);
        }
    }
    // ------------------- MAIN METHOD -------------------
    public static void main(String[] args) throws SQLException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_db",
                "root",
                "Capg@123"
        );

        // ------------------- INSERT USING PREPARED STATEMENT -------------------

//        String sql = "INSERT INTO emp VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//// Setting values
//        ps.setInt(1, 1234);
//        ps.setString(2, "Sanidhya");
//        ps.setString(3, "Engineer");
//        ps.setInt(4, 7698);
//        ps.setDate(5, java.sql.Date.valueOf("1981-02-20"));
//        ps.setDouble(6, 1600.00);
//        ps.setDouble(7, 300.00);
//        ps.setInt(8, 30);
//
//// Execute query
//        int rows = ps.executeUpdate();
//
//        if (rows > 0)
//            System.out.println("Employee inserted successfully!");
//        else
//            System.out.println("Insert failed!");

        // ------------------- UPDATE -------------------
//        String sql = "UPDATE emp SET sal = ? WHERE empno = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//        ps.setDouble(1, 2500.00);
//        ps.setInt(2, 1234);
//
//        int rowsUpdated = ps.executeUpdate();
//
//        if (rowsUpdated > 0)
//            System.out.println("Employee updated successfully!");
//        else
//            System.out.println("Update failed!");

        // ------------------- VIEW AFTER UPDATE -------------------
        //viewEmployees(conn);
        //--------------------delete-----------
        String sql = "DELETE FROM emp WHERE empno = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 9994);

        int rowsDeleted = ps.executeUpdate();

        if (rowsDeleted > 0)
            System.out.println("Employee deleted successfully!");
        else
            System.out.println("Delete failed!");
        viewEmployees(conn);
    }
}