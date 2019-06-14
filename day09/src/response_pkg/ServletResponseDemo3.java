package response_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletResponseDemo3" ,urlPatterns = "/ServletResponseDemo3")

/*
* 案例：定时刷新
* */
public class ServletResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //定时刷新
//        response.setHeader("refresh","1"); //每隔一秒刷新子页面

        /*
        * 隔n秒之后跳转到另外到资源
        * */
        response.setHeader("refresh","3;url=/day09/testParam.html"); //隔3秒后跳转到对应资源
    }
}
