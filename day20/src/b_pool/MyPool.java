package b_pool;

import utils.JdbcUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/*
 * 自定义连接池，管理连接
 * */
public class MyPool {
    private int init_count = 3;  //初始化的连接数目
    private int max_count = 6;      //数据库最大连接数
    private int current_count = 0;  //当前使用的连接数
    //连接池（存放所有初始化连接）
    private LinkedList<Connection> pool = new LinkedList<>();

    //1.构造函数，初始化连接放入连接池
    public MyPool() {

        //初始化连接
        for (int i = 0; i < init_count; i++) {
            //记录当前连接数目
            current_count++;
            //把连接加入连接池
            pool.addLast(createConnection());
        }
    }

    //2.创建一个新的连接
    public Connection createConnection() {
        return JdbcUtil.getConnection();
    }

    //3.获取连接
    public Connection getConnection() {
        //如果连接池中有连接，直接取出
        if (pool.size() > 0) {
            return pool.removeFirst();
        }
        //若连接池无连接，且未达到醉倒连接数，创建新连接
        if (current_count < max_count) {
            current_count++;
            Connection conn = createConnection();
            return conn;
        }
        throw new RuntimeException("当前已达到最大连接数目");
    }

    //4.释放连接
    public void realeaseConnection(Connection connection) {
        //判断池中连接数目小于初始化连接数，就释放入池中
        if (pool.size() < init_count) {
            pool.addLast(connection);
        } else {
            try {
                current_count--;
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyPool pool = new MyPool();
        System.out.println("当前连接: "+pool.current_count);

        Connection connection = pool.getConnection();
        pool.getConnection();
        pool.getConnection();
        pool.getConnection();
        pool.getConnection();
        pool.getConnection();
        pool.realeaseConnection(connection);
        pool.getConnection();
        System.out.println("连接池："+pool.pool.size());
        System.out.println("当前连接："+pool.current_count);
    }

}
