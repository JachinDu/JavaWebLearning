package a_path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* web应用中的路径问题
* */
@WebServlet(name = "ServletPathDemo",urlPatterns = "/ServletPathDemo")
public class ServletPathDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        /*
        * 目标资源给谁用：
        *           给服务器用：/表示在当前web应用的根目录
        *           给浏览器用：/表示在webapp的根目录下,先跳回web应用根目录
        * */

        /*
        * 1.转发
        * */
        //request.getRequestDispatcher("/target.html").forward(request,response);


        /*
        * 2.请求重定向
        * */
        //response.sendRedirect("/day11/target.html");


        /*
        * 3.html页面的超链接href
        * */
        response.getWriter().write("<html><body><a href='/day11/target.html'>超链接</a></body></html>");


        /*
        * 4.html页面中的form提交地址
        * */
        response.getWriter().write("<html><body><form action='/day11/target.html'><input type='submit'/></form></body></html>");
    }
}
