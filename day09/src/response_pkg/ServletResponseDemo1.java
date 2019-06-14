package response_pkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletResponseDemo1",urlPatterns = "/ServletResponseDemo1")

/*
* 设置响应信息
* */
public class ServletResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过response对象改变响应信息

        //1、响应行
//        response.setStatus(404); //修改状态码
//        response.sendError(404); // 发送404状态吗+404错误页面

        //2、响应头
        response.setHeader("server","JBoss");

        //3、实体内容(浏览器能直接看到的内容)
        response.getWriter().write("01 hello world"); //字符内容
        //response.getOutputStream().write("02 hello world".getBytes()); //字节内容

    }
}
