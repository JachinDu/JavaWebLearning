package a_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* servlet多线程并发问题
* */
@WebServlet(name = "ServletThreadDemo" ,urlPatterns = "/ServletThreadDemo")
public class ServletThreadDemo extends HttpServlet {
    int count = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");  //解决中文乱码

        /*
        * 避免第一个线程执行完write，但还未执行count++时，线程2就开始执行write，导致两个线程看到但count都是1
        * */
        synchronized (ServletThreadDemo.class) { //锁对象必须唯一,使用类对象，就是唯一的
            response.getWriter().write("你现在是当前网站的第"+count+"个访客");
            count++;
        }

    }
}
