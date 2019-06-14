package cn.itcast.path;

        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

public class DBUtil {
    static Properties properties;

    static {
        properties = new Properties();
        //加载配置文件
        Class clazz = DBUtil.class; //先获取Class对象
        InputStream inputStream = clazz.getResourceAsStream("/cn/itcast/path/db.properties");//该方法使用的路径就是类文件路径,"/"代表了classpath的路径
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("当前路径："+ new File(".").getAbsolutePath());
        System.out.println("用户名： "+ properties.getProperty("userName")+" 密码 ："+ properties.getProperty("password"));
    }
}
