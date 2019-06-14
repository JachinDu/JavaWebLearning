package d_dbUtils;

import c_jdbc.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class App_query {
    private Connection conn;

    //1.查询，自定义结果集封装数据
    //封装自定义，不仅限于javabean对象，比如成员变量是其他类的对象
    @Test
    public void testUpdate() throws SQLException {
        String sql = "select * from admin where id=?";
        conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();

        Admin admin = qr.query(conn, sql, new ResultSetHandler<Admin>() {
            //如何封装一个Admin对象
            @Override
            public Admin handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(resultSet.getInt("id"));
                    admin.setUserName(resultSet.getString("userName"));
                    admin.setPassword(resultSet.getString("password"));
                    return admin;
                }
                return null;
            }
        }, 11);

        //测试
        System.out.println(admin);
        conn.close();
    }

    //2.查询，使用组件提供的结果集对象封装数据
    //BeanHandler,只适用于javabean对象
    //1）查询返回单个对象
    @Test
    public void testQueryOne() throws SQLException {
        String sql = "select * from admin where id=?";
        conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        Admin admin = qr.query(conn,sql,new BeanHandler<Admin>(Admin.class),11);
        System.out.println(admin);
        conn.close();
    }

    //2）查询返回list
    @Test
    public void testQueryMany() throws SQLException {
        String sql = "select * from admin";
        conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        List<Admin> list = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
        System.out.println(list);
        conn.close();
    }

    //3)ArrayHandler,查询返回结果记录的第一行，封装为对象数组，即返回Object[]
    //4)ArrayListHandler,把查询的每一行都封装为对象数组，再添加到list中
    //5)ScalarHandler,查询返回结果记录的第一行第一列
    //6)MapHandler,查询返回结果的第一条记录封装为map
    @Test
    public void testArray() throws SQLException {
        String sql = "select * from admin";
        conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();

        //Object[] obj = qr.query(conn, sql, new ArrayHandler());
        //List<Object[]> list = qr.query(conn, sql, new ArrayListHandler());
        //Integer num = qr.query(conn, sql, new ScalarHandler<Integer>());
        Map<String,Object> map = qr.query(conn, sql, new MapHandler());
        conn.close();
    }


}
