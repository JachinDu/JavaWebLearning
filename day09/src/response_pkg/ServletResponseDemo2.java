package response_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletResponseDemo2",urlPatterns = "/ServletResponseDemo2")

/*
* 案例：请求重定向
* （相当于超链接跳转页面）
* */
public class ServletResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 需求：跳转到testParam.html
        * 方法：发送一个302状态码+location的响应头
        * */
        //法一
//        response.setStatus(302);
//        response.setHeader("location","/day09/testParam.html");
        //法二
        response.sendRedirect("/day09/testParam.html");
    }
}
