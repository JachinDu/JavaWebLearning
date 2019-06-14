package day12.contact.servlet;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.dao.impl.ContactDaoMySQLImpl;
import day12.contact.entity.Contact;
import day12.contact.service.ContactService;
import day12.contact.service.impl.ContactServiceImpl;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 修改前查询联系人
* */
@WebServlet(name = "ServletQueryContact",urlPatterns = "/ServletQueryContact")
public class ServletQueryContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String id = request.getParameter("id");
        //2.调用dao根据id查询联系人的方法
        ContactService service = new ContactServiceImpl();
        Contact contact = null;
        try {
            contact = service.findById(id);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //2.将数据存如域中
        request.setAttribute("contact",contact);
        //3.把联系人发送到jsp
        request.getRequestDispatcher("QueryContact.jsp").forward(request,response);
    }
}
