package response_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletResponseDemo4" , urlPatterns = "/ServletResponseDemo4")

/*
* 案例：content-Type作用
* */
public class ServletResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 服务器发送给浏览器的数据类型
        * */
        //法一
        //response.setHeader("content-type","text/html");
        //法二(推荐)
        //response.setContentType("text/html"); //浏览器会用这个类型去解析下面的内容
        //response.getWriter().write("<html><head><title>this is title</title></head><body>this is body</body></html>");
        response.setContentType("image/jpg");  //图片类型写法

        /*
        * 设置以下载方式打开文件
        * */
        File file = new File("/Users/jc/Desktop/1.jpg");
        response.setHeader("Content-Disposition","attachment; filename="+file.getName());

        /*
        * 发送图片
        * */
        FileInputStream in = new FileInputStream(new File("/Users/jc/Desktop/1.jpg"));
        byte[] buf = new byte[1024];
        int len = 0;

        //把图片内容写出到浏览器
        while ((len = in.read(buf)) != -1) {
            response.getOutputStream().write(buf,0,len);
        }
    }
}
