package d_dbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class App_update {
    private Connection conn;
    /*
    * 更新操作
    * */
    @Test
    public void testUpdate() throws SQLException {

        String sql = "delete from admin where id=?";
        conn = JdbcUtil.getConnection();

        //创建dbUtils核心工具类对象
        QueryRunner qr = new QueryRunner();
        qr.update(conn,sql,10);
    }


    /*
    * 批处理
    * */
    @Test
    public void testBatch() throws SQLException {
        String sql = "insert into admin (userName,password) values(?,?)";
        conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        qr.batch(conn, sql, new Object[][]{{"jack1", "999"}, {"jack2", "3222"}});
        conn.close();
    }
}
