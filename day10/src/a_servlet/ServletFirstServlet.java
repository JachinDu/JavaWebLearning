package a_servlet;

/*
* 声明周期
* */

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ServletFirstServlet extends javax.servlet.http.HttpServlet {

    /*
     * 1.构造方法
     * */
    public ServletFirstServlet() {
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

//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
//
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
}
