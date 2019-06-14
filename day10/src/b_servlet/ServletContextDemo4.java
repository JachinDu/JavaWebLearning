package b_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContextDemo4",urlPatterns = "/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到域对象,必须域共享数据的servlet同一个域对象
        //因为ServletContext对象全局只有一个，所以二者拿到的域对象一定是同一个
        ServletContext context = this.getServletContext();
        //2.从域对象中取出数据
        Student student = (Student) context.getAttribute("student");
        System.out.println(student);
    }
}
