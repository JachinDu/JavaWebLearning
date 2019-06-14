package a_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletContextDemo2",urlPatterns ="/ServletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.得到servletcontext对象
        ServletContext context = this.getServletContext();
        System.out.println("参数："+ context.getInitParameter("aaa"));
        Enumeration<String> enums = context.getInitParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = enums.nextElement();
            String paramValue = context.getInitParameter(paramName);
            System.out.println(paramName+"="+paramValue);
        }
    }
}
