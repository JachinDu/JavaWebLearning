package request_servlet_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@WebServlet(name = "request", urlPatterns = "/servletReq")

/*
* 请求数据获取
* */
public class request extends HttpServlet {

    /*
    * 1)tomcat服务器接收到浏览器发送到请求数据，然后封装到HttpServletRequest对象
    * 2)tomcat服务器调用doGet方法，把request对象传入到servlet中
    * */

    //doPost才能接受POST方式提交的请求，doGet不行
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实体内容
        InputStream in = request.getInputStream();   //得到实体内容
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            String str = new String(buf, 0, len);
            System.out.println(str);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //t1(request);
        //t2(request);


    }

    private void t2(HttpServletRequest request) {
        //请求头
        String host = request.getHeader("Host");  //得到指定名称的请求头
        System.out.println(host);

        //Enumeration类似于Iterator
        //遍历所有请求头
        Enumeration<String> enums = request.getHeaderNames();  //得到所有请求头的列表
        while (enums.hasMoreElements()) { //判断是否有下一个元素
            String headerName = enums.nextElement();   //取出下一个元素
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName+":"+headerValue);

        }
    }

    private void t1(HttpServletRequest request) {
        /*
         * 3)从request对象中取出请求数据
         *
         * */

        //请求行
        System.out.println("请求方式：" +request.getMethod());
        System.out.println("URI：" +request.getRequestURI());
        System.out.println("URL："+request.getRequestURL());
        System.out.println("http协议版本："+request.getProtocol());
    }
}
