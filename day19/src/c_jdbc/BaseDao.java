package c_jdbc;

import org.apache.commons.beanutils.BeanUtils;
import utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* 通用dao,自己写的所有dao都继承此类；
* 此类定义了2个通用都方法：
*   1、更新
*   2、查询
* */
public class BaseDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    /*
    * 更新都通用方法
    * sql: 更新语句
    * paramsValue: sql语句中的占位符对应的参数值
    * */
    public void update(String sql, Object[] paramsValue) {

        try {
            conn = JdbcUtil.getConnection();

            pstmt = conn.prepareStatement(sql);

            int count = pstmt.getParameterMetaData().getParameterCount();

            if (paramsValue != null && paramsValue.length > 0) {
                for (int i = 0; i < count; i++) {
                    pstmt.setObject(i + 1, paramsValue[i]);

                }
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }finally {
            JdbcUtil.close(conn,pstmt);
        }
    }

    /*
     * 查询的通用方法
     * */
    public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz) {
        try {
            //返回的集合
            List<T> list = new ArrayList<T>();
            T t = null;

            //1.获取连接
            conn = JdbcUtil.getConnection();
            //2.创建stmt对象
            pstmt = conn.prepareStatement(sql);
            //3.获取占位符参数个数，并设置参数值
            int count = pstmt.getParameterMetaData().getParameterCount();
            if (paramsValue != null && paramsValue.length > 0) {
                for (int i = 0; i < count; i++) {
                    pstmt.setObject(i + 1, paramsValue[i]);

                }
            }
            //4.执行查询
            rs = pstmt.executeQuery();
            //5.获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();//获取列的个数
            //6.遍历rs
            while (rs.next()) {//行
                //要封装的对象
                t = clazz.newInstance();
                //每一行的每一列
                for (int i = 0; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object value = rs.getObject(columnName);
                    //封装
                    BeanUtils.copyProperty(t,columnName,value);
                }
                //将封装好的对象添加到集合中
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,pstmt);
        }
    }
}
