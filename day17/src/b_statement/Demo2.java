package b_statement;
/*
* 使用statement执行dml语句
* */

import jdbc_util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
    private String url = "jdbc:mysql://localhost:3306/day17";
    private String user = "root";
    private String password = "5774857";
    /*
    * 增加
    * */
    @Test
    public void testInsert() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JdbcUtil.getConnection();

            stmt = conn.createStatement();

            String sql = "insert into student(name,gender) values('陈六','男')";

            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn,stmt);

        }

    }


    /*
     * 修改
     * */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "update student set name ='王五' where id=1";

            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
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
