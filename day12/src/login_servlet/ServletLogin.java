package login_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialStruct;
import java.io.IOException;

/*
* 处理登陆逻辑
* */
@WebServlet(name = "ServletLogin",urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.接收表带提交的参数
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //2.判断逻辑
        if ("eric".equals(userName) && "123456".equals(userPwd)) {
            //登陆成功
            /*
            * 把用户数据保存在session中
            * */
            //1.创建session
            HttpSession session = request.getSession();
            //2.把数据保存到session域中
            session.setAttribute("loginName",userName);
            //3.跳转到用户主页
            response.sendRedirect(request.getContextPath()+"/ServletIndex");

        } else {
            //登陆失败
            //请求重定向
            response.sendRedirect(request.getContextPath()+"/fail.html");
        }

    }
}
