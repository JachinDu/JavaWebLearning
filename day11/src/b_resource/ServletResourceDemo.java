package b_resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* 读取web应用下的资源文件，如properties
* */
@WebServlet(name = "ServletResourceDemo",urlPatterns = "/ServletResourceDemo")
public class ServletResourceDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 使用web应用下加载资源文件的方法
        * */
        /*
        * 1.getRealPath()方法，返回资源文件的绝对路径
        * */
//        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
//        System.out.println(path);
//
//        File file = new File(path);
//        FileInputStream in = new FileInputStream(file);

        /*
        * 2.getResourceAsStream()得到资源文件，返回输入流
        * */
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        Properties prop = new Properties();
        //读取资源文件
        prop.load(in);
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println("user="+user);
        System.out.println("password="+password);

    }
}
