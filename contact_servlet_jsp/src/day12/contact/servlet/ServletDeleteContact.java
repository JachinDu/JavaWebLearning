package day12.contact.servlet;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.entity.Contact;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteContact",urlPatterns = "/ServletDeleteContact")
public class ServletDeleteContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String id = request.getParameter("id");
        //2.调用dao删除联系人方法
        ContactDao dao = new ContactDaoImpl();
        try {
            dao.deleteContact(id);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //3.返回查询联系人界面
        response.sendRedirect(request.getContextPath()+"/ServletListContact");
    }
}
