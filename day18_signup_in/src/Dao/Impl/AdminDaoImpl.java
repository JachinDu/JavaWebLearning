package Dao.Impl;

import Dao.IAdminDao;
import entity.Admin;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 数据访问层,实现类
 * */
public class AdminDaoImpl implements IAdminDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public void save(Admin admin) {
        String sql = "insert into admin(userName,password) values(?,?)";
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,admin.getUserName());
            pstmt.setString(2,admin.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,pstmt);
        }
    }

    @Override
    public Admin findByNameAndPwd(Admin admin) {
        String sql = "select * from admin where userName=? and password=?";
        Admin ad = null;
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,admin.getUserName());
            pstmt.setString(2,admin.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                ad = new Admin();
                ad.setId(rs.getInt("id"));
                ad.setUserName(rs.getString("userName"));
                ad.setPassword(rs.getString("password"));
            }
            return ad;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,pstmt,rs);
        }
    }

    @Override
    public boolean userExists(String name) {
        String sql = "select id from admin where userName=?";
        try {
            conn = JdbcUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                if (id > 0) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,pstmt,rs);
        }
    }
}
