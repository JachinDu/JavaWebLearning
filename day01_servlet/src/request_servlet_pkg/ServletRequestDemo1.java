package request_servlet_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ServletRequestDemo1", urlPatterns = "ServletRequestDemo1")
public class ServletRequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取POST提交参数
        InputStream in = request.getInputStream();   //得到实体内容
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            String str = new String(buf, 0, len);
            System.out.println(str);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET方式");
        //接受GET提交的参数
        String value = request.getQueryString();
        System.out.println(value);
    }
}
