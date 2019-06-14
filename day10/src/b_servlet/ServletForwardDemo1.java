package b_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletForwardDemo1",urlPatterns = "/ServletForwardDemo1")
public class ServletForwardDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 保存数据到request域对象
        * */
        request.setAttribute("name","rose");

        //转发(不能转发当前web应用以外的资源
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ServletGetData");
        rd.forward(request,response);
    }
}
