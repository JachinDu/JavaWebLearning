package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;
import java.sql.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoddessDao {

    public void addGoddess(Goddess g) throws SQLException {
        //1.首先要获得数据库到连接
        Connection conn= DBUtil.getConnection();
        //2.写sql语句
        String sql = "" +
                    "insert into imooc_goddess" +
                    "(user_name,sex,age,birthday,email,mobile,"+
                    "create_user,create_date,update_user,update_date,isdel)"+
                    "values("+
                    "?,?,?,?,?,?,?,current_date,?,current_date,?)";

        //3.预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //4.传参，替代上面的问号
        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreate_user());
        ptmt.setString(8,g.getUser_name());
        ptmt.setInt(9,g.getIsdel());

        //5.执行sql语句
        ptmt.execute();
    }

    public void updateGoddess(Goddess g) throws SQLException {

        //1.首先要获得数据库到连接
        Connection conn= DBUtil.getConnection();
        //2.写sql语句
        String sql = "" +
                " update imooc_goddess " +
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                " update_user=?,update_date=current_date(),isdel=? " +
                " where id=?";

        //3.预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //4.传参，替代上面的问号
        ptmt.setString(1, g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getUpdate_user());
        ptmt.setInt(8,g.getIsdel());
        ptmt.setInt(9,g.getId());

        //5.执行sql语句
        ptmt.execute();

    }

    public void delGoddess(Integer id) throws SQLException {

        //1.首先要获得数据库到连接
        Connection conn= DBUtil.getConnection();
        //2.写sql语句
        String sql = "" +
                " delete from imooc_goddess " +
                " where id=?";

        //3.预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //4.传参，替代上面的问号
        ptmt.setInt(1,id);

        //5.执行sql语句
        ptmt.execute();

    }

    public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
        Connection conn= DBUtil.getConnection();
        //Statement stmt = conn.createStatement();
        //ResultSet rs = stmt.executeQuery("select * from imooc_goddess");
        StringBuilder sb = new StringBuilder();
        sb.append("select * from imooc_goddess where 1=1 ");
//        String sql = "" +
//                " select * from imooc_goddess ";

        List<Goddess> gs = new ArrayList<Goddess>();

        if (params != null&&params.size()>0){
            for ( int i = 0; i < params.size(); i++){
                Map<String, Object> map = params.get(i);
                sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
            }
        }

        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        System.out.println(sb.toString());
        ResultSet rs = ptmt.executeQuery();
        Goddess g = null;
        //rs.next(): 当rs这个对象中有数据则返回true
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
            gs.add(g);

        }
        return gs;
    }

    public Goddess get(Integer id) throws SQLException {

        Goddess g = null;
        //1.首先要获得数据库到连接
        Connection conn= DBUtil.getConnection();
        //2.写sql语句
        String sql = "" +
                " select * from imooc_goddess " +
                " where id=?";

        //3.预编译
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //4.传参，替代上面的问号
        ptmt.setInt(1,id);

        //5.执行sql语句
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_date(rs.getDate("update_date"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

        }
        return g;
    }
}
