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
        ContactDao dao = new ContactDaoImpl();
        List<Contact> list = null;
        try {
            list = dao.findAll();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //2.把结果保存到域对象中
        request.setAttribute("contacts",list);
        //3.跳转到jsp页面
        request.getRequestDispatcher("/ListContact.jsp").forward(request,response);

    }
}
