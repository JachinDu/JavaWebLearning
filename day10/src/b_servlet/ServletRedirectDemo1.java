package b_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRedirectDemo1",urlPatterns = "/ServletRedirectDemo1")
public class ServletRedirectDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 保存数据到request域对象
         * */
        request.setAttribute("name","rose");

        response.sendRedirect("/day10/ServletGetData");
    }
}
