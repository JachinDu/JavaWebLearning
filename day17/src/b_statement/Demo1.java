package b_statement;

import org.junit.Test;

import java.sql.*;

public class Demo1 {
    private String url = "jdbc:mysql://localhost:3306/day17";
    private String user = "root";
    private String password = "5774857";
    /*
     * 执行ddl语句
     * */
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();

            String sql = "create table student(id int primary key auto_increment,name varchar(20),gender varchar(2))";

            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }


    }

}
