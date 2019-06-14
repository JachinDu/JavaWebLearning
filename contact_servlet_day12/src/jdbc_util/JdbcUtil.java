package jdbc_util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
* jdbc工具类
* */
public class JdbcUtil {

    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driverClass = null;

    /*
    * 静态代码块（只加载一次）
    * */
    static {

        try {
            Properties properties = new Properties();
            //FileInputStream in = new FileInputStream("./src/db.properties");
            InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
            properties.load(in);

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driverClass = properties.getProperty("driverClass");

            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动程序注册出错");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 抽取获取连接对象的方法
    * */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /*
     * 释放资源方法
     * */
    public static void close(Connection connection, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }
    }

    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);

            }
        }
    }
}
