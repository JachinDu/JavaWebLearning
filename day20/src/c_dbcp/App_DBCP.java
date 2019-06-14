package c_dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class App_DBCP {

    //硬编码方式实现连接池
    @Test
    public void testDbcp() throws SQLException {
        //DBCP连接池核心类
        BasicDataSource dataSource = new BasicDataSource();
        //连接池参数配置（初始化连接数，最大连接数）

        dataSource.setUrl("jdbc:mysql://localhost:3306/day18");   //数据库连接字符串
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");   //驱动
        dataSource.setUsername("root");
        dataSource.setPassword("5774857");

        dataSource.setInitialSize(3);
        dataSource.setMaxTotal(6);   //最大连接
        dataSource.setMaxIdle(3000); //最大空闲时间


        //获取连接
        Connection conn = dataSource.getConnection();
        conn.prepareStatement("delete from admin where id=15").executeUpdate();
        conn.close();
    }

    //2.配置方式实现连接池
    @Test
    public void testProp() throws Exception {
        //加载prop配置文件
        Properties prop = new Properties();
        InputStream inputStream = App_DBCP.class.getResourceAsStream("/db.properties");
        prop.load(inputStream);

        //根据prop创建数据源对象
        DataSource dataSource = BasicDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        conn.prepareStatement("delete from admin where id=12").executeUpdate();
        conn.close();
    }
}
