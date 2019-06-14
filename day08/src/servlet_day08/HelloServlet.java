package servlet_day08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HelloServlet extends HttpServlet {
    //必须覆盖doGet方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setContentType("text/html;charset=utf-8");
        //向浏览器输出内容
        resp.getWriter().write("这是第一个servlet程序。当前时间：" + new Date());
    }
}
