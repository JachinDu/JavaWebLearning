package d_c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    //1.硬编码方式实现
    @Test
    public void testCode() throws PropertyVetoException, SQLException {
        //创建连接池核心工具类
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置连接参数
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day18");   //数据库连接字符串
        dataSource.setDriverClass("com.mysql.jdbc.Driver");   //驱动
        dataSource.setUser("root");
        dataSource.setPassword("5774857");

        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);   //最大连接
        dataSource.setMaxIdleTime(3000); //最大空闲时间

        //从连接池获取对象
        Connection conn = dataSource.getConnection();
        //执行
        conn.prepareStatement("delete from admin where id=14").executeUpdate();
        conn.close();
    }

    //2.XML配置方式，使用C3P0管理连接
    @Test
    public void testXML() throws SQLException {
        //创建连接池核心工具类
        //自动加载src下c3p0的配置文件【c3p0-config.xml】
        ComboPooledDataSource dataSource = new ComboPooledDataSource("jiacheng_config");//不指定加载默认配置
        Connection conn = dataSource.getConnection();
        conn.prepareStatement("delete from admin where id=13").executeUpdate();

        conn.close();
    }
}
