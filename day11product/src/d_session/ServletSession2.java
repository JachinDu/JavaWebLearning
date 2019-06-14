package d_session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletSession2",urlPatterns = "/ServletSession2")
public class ServletSession2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建session对象
        HttpSession session = request.getSession(false);

        if (session == null) {
            System.out.println("没有对应的session对象");
            return;
        }

        /*
         * 得到session编号
         * */
        System.out.println("id="+session.getId());

        //2.取出数据
        String name = (String) session.getAttribute("name");
        System.out.println("name="+name);
    }
}
