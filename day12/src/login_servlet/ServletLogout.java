package login_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogout",urlPatterns = "/ServletLogout")
public class ServletLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 安全退出：
        *        删除掉session对象中的loginName属性，而不是删掉整个session
        * */
        //1.得到session
        HttpSession session = request.getSession(false);
        if (session != null) {
            //2.删除属性
            session.removeAttribute("loginName");
        }
        //3.回到登陆页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}
