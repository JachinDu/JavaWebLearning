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
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
* 显示所有联系人
* */
@WebServlet(name = "ServletListContact",urlPatterns = "/ServletListContact")
public class ServletListContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从xml中读取
        ContactService service = new ContactServiceImpl();
        List<Contact> list = null;
        try {
            list = service.findAll();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //2.将数据保存到域对象中
        request.setAttribute("contact",list);

        //3.发送到jsp页面
        request.getRequestDispatcher("ListContact.jsp").forward(request,response);

    }
}
