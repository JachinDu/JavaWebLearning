package com.imooc.db;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Goddess?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "jiacheng0801";

    private static Connection conn = null;

    static {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获得数据库到连接
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }


//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//
//
//        //3.通过数据库到连接操作数据库，实现增删改查
////        Statement stmt = conn.createStatement();
////        ResultSet rs = stmt.executeQuery("select cust_name,cust_city from Customers");
////
////        //rs.next(): 当rs这个对象中有数据则返回true
////        while(rs.next()){
////            System.out.println(rs.getString("cust_name") + "," + rs.getString("cust_city"));
////
////        }
//
//    }
}
