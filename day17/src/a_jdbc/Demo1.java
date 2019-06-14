package a_jdbc;

/*
* jdbc连接数据库
* */

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo1 {

    private String url = "jdbc:mysql://localhost:3306/day17";
    private String user = "root";
    private String password = "5774857";

    @Test
    public void test1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection conn = driver.connect(url, props);
        System.out.println(conn);

    }

    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
