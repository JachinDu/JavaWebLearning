package c_prepared;

import jdbc_util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* 模拟用户登陆
* */
public class Demo2 {

    private String name = "eric";
    private String password = "1234";
    ResultSet rs = null;

    @Test
    public void test1() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JdbcUtil.getConnection();

            stmt = conn.createStatement();

            String sql = "select * from users where name='"+name+"' and password='"+password+"'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }


    @Test
    public void testByPreparedStatement() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = JdbcUtil.getConnection();

            String sql = "select * from users where name=? and password=?";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, name);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }
}
