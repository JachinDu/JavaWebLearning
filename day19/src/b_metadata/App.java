package b_metadata;

import a_beans.Admin;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    //1.数据库元数据操作
    @Test
    public void testDB() throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        DatabaseMetaData metaData = conn.getMetaData();

        System.out.println(metaData.getUserName());
        System.out.println(metaData.getURL());
    }

    //2.参数元数据操作
    @Test
    public void testParams() throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from admin where id=? and userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ParameterMetaData p_metaData = pstmt.getParameterMetaData();
        int count = p_metaData.getParameterCount();
        System.out.println(count);
    }

    //3.结果集元数据
    @Test
    public void testRs() throws SQLException {
        String sql = "select * from admin";
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rs_metaData = rs.getMetaData();
        while (rs.next()) {
            int count = rs_metaData.getColumnCount();
            for (int i = 0; i < count; i++) {
                String columnName = rs_metaData.getColumnName(i+1);
                Object columnValue = rs.getObject(columnName);
                System.out.println(columnName+"="+columnValue+",");
            }
            System.out.println();
        }

    }
}
