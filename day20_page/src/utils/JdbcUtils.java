package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/*
 * 工具类
 * 1、初始化c3p0连接池
 * 2、创建DbUtils核心工具类对象
 * */
public class JdbcUtils {
    //1、
    private static DataSource dataSource;
    static{
        dataSource = new ComboPooledDataSource();
    }

    //2
    public static QueryRunner getQueryRunner() {
        //创建QueryRunner对象，传入连接池对象
        //若有连接对象作为参数传入，则在使用QueryRunner对象方法时无需传入连接对象
        //不用关闭连接
        return new QueryRunner(dataSource);
    }
}
