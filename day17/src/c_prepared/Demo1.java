package c_prepared;
/*
* preparedStatement执行sql语句
* */
import jdbc_util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Demo1 {

    /*
    * 增加
    * */
    @Test
    public void test1() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = JdbcUtil.getConnection();
            //预编译的sql语句(检查语法)
            String sql = "insert into student(name,gender) values(?,?)";//?表示一个参数的占位符
            //执行预编译sql语句
            stmt =  conn.prepareStatement(sql);

            //设置参数值
            /*
            * 第一个参数是参数的位置，从1开始
            * */
            stmt.setString(1,"坎坷");
            stmt.setString(2,"男");

            int count = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,stmt);
        }
    }
}
