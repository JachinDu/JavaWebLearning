package a_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInitDemo1",urlPatterns = "/ServletInitDemo1")
public class ServletInitDemo1 extends HttpServlet {

    /*
    * 有参init
    * 该方法是servlet生命周期方法，一定会被tomcat调用
    * 如果要编写初始化代码在无参init中，则不要覆盖有参init
    * */
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println("有参的init方法");
//    }


    /*
    * 无参init方法
    * 该方法是servlet的编写初始化代码的方法。让开发者在里面覆盖，编写初始化逻辑代码
    * */
    @Override
    public void init() throws ServletException {
        System.out.println("无参的init方法");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
