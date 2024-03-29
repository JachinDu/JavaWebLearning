package a_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLifeDemo1" , urlPatterns = "/ServletLifeDemo1")
public class ServletLifeDemo1 extends HttpServlet {

    /*
     * 1.构造方法
     * */
    public ServletLifeDemo1() {
        System.out.println("1.servlet对象创建了");
    }

    /*
     * 2.init方法
     * */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2.init方法被调用");
    }

    /*
     * 3.service方法
     * */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("2.service方法被调用");
    }

    /*
     * 4.destroy方法
     * */
    @Override
    public void destroy() {
        System.out.println("4.servlet对象已销毁");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
