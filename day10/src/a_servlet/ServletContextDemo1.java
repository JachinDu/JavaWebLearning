package a_servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 得到web应用路径
* */

@WebServlet(name = "ServletContextDemo1",urlPatterns = "/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.得到servletcontext对象
//        ServletContext context = this.getServletConfig().getServletContext();
        ServletContext context = this.getServletContext();  //推荐使用
         //2.得到web应用路径:/day10
         String contextPath = context.getContextPath();
        System.out.println(contextPath);

        /*
        * 案例：应用到请求重定向
        * */
        response.sendRedirect("/day10/index.html");
        response.sendRedirect(contextPath+"/index.html");
    }
}
