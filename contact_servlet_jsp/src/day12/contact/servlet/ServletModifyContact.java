package day12.contact.servlet;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.entity.Contact;
import day12.contact.util.XMLUti;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletModifyContact",urlPatterns = "/ServletModifyContact")
public class ServletModifyContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //XMLUti.storeContact(request,response);
        //1.接收参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");

        //2.封装称contact对象
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setAge(Integer.parseInt(age));
        contact.setGender(gender);
        contact.setPhone(phone);
        System.out.println(contact);
        //3.调用dao类的修改联系人方法
        ContactDao dao = new ContactDaoImpl();
        try {
            dao.modifyContact(contact);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        //4.跳转到查询所有联系人页面
        response.sendRedirect(request.getContextPath()+"/ServletListContact");
    }
}
