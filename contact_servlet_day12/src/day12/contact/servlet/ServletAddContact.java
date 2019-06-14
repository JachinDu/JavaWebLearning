package day12.contact.servlet;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.entity.Contact;
import day12.contact.exception.NameRepeatException;
import day12.contact.service.ContactService;
import day12.contact.service.impl.ContactServiceImpl;
import day12.contact.util.XMLUti;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
/*
* 添加联系人
* */
@WebServlet(name = "ServletAddContact",urlPatterns = "/ServletAddContact")
public class ServletAddContact extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //XMLUti.storeContact(request,response);
        //1.接收参数
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");



        //2.封装称contact对象
        Contact contact = new Contact();
        contact.setName(name);
        contact.setAge(Integer.parseInt(age));
        contact.setGender(gender);
        contact.setPhone(phone);

        //3.调用dao类的添加联系人方法
        ContactService service = new ContactServiceImpl();
        try {
            //service在调用addContact之前会检查是否重复
            service.addContact(contact);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } catch (NameRepeatException e) {
            //处理自定义业务异常（姓名重复异常）
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/addPeople.jsp").forward(request,response);
        }
        //4.跳转到查询所有联系人页面
        response.sendRedirect(request.getContextPath()+"/ServletListContact");
    }
}
