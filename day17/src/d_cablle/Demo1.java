package d_cablle;

import jdbc_util.JdbcUtil;
import org.junit.Test;

import java.sql.*;

public class Demo1 {

    @Test
    public void test1() {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtil.getConnection();

            String sql = "call pro_findById(?)";

            stmt = conn.prepareCall(sql);

            stmt.setInt(1,4);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                System.out.println(id+","+name+","+gender);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(conn,stmt,rs);
        }
    }


}
