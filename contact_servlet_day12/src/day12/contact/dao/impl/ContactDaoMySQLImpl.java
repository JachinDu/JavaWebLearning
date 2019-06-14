package day12.contact.dao.impl;

import day12.contact.dao.ContactDao;
import day12.contact.entity.Contact;
import jdbc_util.JdbcUtil;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDaoMySQLImpl implements ContactDao {

    @Override
    public void addContact(Contact contact) throws DocumentException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into contact(id,name,gender,age,phone) values(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            String id = UUID.randomUUID().toString().replace("-", "");
            stmt.setString(1,id);
            stmt.setString(2, contact.getName());
            stmt.setString(3, contact.getGender());
            stmt.setInt(4, contact.getAge());
            stmt.setString(5, contact.getPhone());

            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public void modifyContact(Contact contact) throws DocumentException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "update contact set name=?,gender=?,age=?,phone=? where id=?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getGender());
            stmt.setInt(3, contact.getAge());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5,contact.getId());


            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public void deleteContact(String id) throws DocumentException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from contact where id=?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1,id);


            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }

    @Override
    public List<Contact> findAll() throws DocumentException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from contact";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            List<Contact> list = new ArrayList<>();
            while (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setAge(rs.getInt("age"));
                c.setPhone(rs.getString("phone"));
                list.add(c);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }

    @Override
    public Contact findById(String id) throws DocumentException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from contact where id=?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1,id);
            rs = stmt.executeQuery();

            Contact c = null;
            if (rs.next()) {
                c = new Contact();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getString("gender"));
                c.setAge(rs.getInt("age"));
                c.setPhone(rs.getString("phone"));
            }
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }

    @Override
    public boolean checkContact(String name) throws DocumentException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from contact where name=?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1,name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtil.close(conn,stmt,rs);
        }    }
}

