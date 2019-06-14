package login_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletIndex",urlPatterns = "/ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String html = "";

        //从session域中获取会话数据
        //1.得到session对象
        HttpSession session = request.getSession(false);
        if (session == null) {
            //没有登陆成功,跳转回登陆页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }
        //2.取出会话数据
        String loginName = (String)session.getAttribute("loginName");
        //判断是否存在指定属性（登陆信息）
        if (loginName == null) {
            //没有登陆成功,跳转回登陆页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        html = "<html><body>欢迎回来，"+loginName+" <a href='"+request.getContextPath()+"/ServletLogout'>安全退出</a></body></html>";
        writer.write(html);
    }
}
