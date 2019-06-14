package Dao.Impl;

import Dao.IAdminDao;
import entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 数据访问层,实现类
 * （引入DbUtils组件简化jdbc操作）
 * */
public class AdminDaoImpl_DbUtils implements IAdminDao {
    private Connection conn;
    @Override
    public void save(Admin admin) {
        String sql = "insert into admin(userName,password) values(?,?)";
        try {
            conn = JdbcUtil.getConnection();
            QueryRunner qr = new QueryRunner();
            qr.update(conn, sql, admin.getUserName(), admin.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,null);
        }
    }

    @Override
    public Admin findByNameAndPwd(Admin admin) {
        String sql = "select * from admin where userName=? and password=?";
        try {
            QueryRunner qr = new QueryRunner();
            conn = JdbcUtil.getConnection();

            Admin ad = qr.query(conn, sql, new BeanHandler<Admin>(Admin.class), admin.getUserName(), admin.getPassword());
            return ad;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,null,null);
        }
    }

    @Override
    public boolean userExists(String name) {
        String sql = "select id from admin where userName=?";
        try {
            conn = JdbcUtil.getConnection();
            QueryRunner qr = new QueryRunner();
            Integer in = qr.query(conn, sql, new ScalarHandler<Integer>(), name);
            if (in != null) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,null,null);
        }
    }
}
