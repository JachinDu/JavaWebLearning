package b_statement;

import jdbc_util.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* 执行dql（查询）语句
* */
public class Demo3 {

    @Test
    public void test1() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "select * from student";

            ResultSet rs = stmt.executeQuery(sql);

//            boolean flag = rs.next();
//            flag = rs.next();
//            flag = rs.next();
//            if (flag) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String gender = rs.getString("gender");
//                System.out.println(id+","+name+","+gender);
//
//            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                System.out.println(id+","+name+","+gender);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn,stmt);
        }
    }
}
