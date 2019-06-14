package day12.contact.util;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.entity.Contact;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class XMLUti {

    public static Document getDocument() throws DocumentException {
        Document doc = new SAXReader().read("/Users/jc/Desktop/contact.xml");
        return doc;
    }

    public static void write2xml(Document doc) throws IOException {
        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();

        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

//    public static void storeContact(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //1.接收参数
//        String name = request.getParameter("name");
//        String gender = request.getParameter("gender");
//        String age = request.getParameter("age");
//        String phone = request.getParameter("phone");
//
//        //2.封装称contact对象
//        Contact contact = new Contact();
//        contact.setName(name);
//        contact.setAge(Integer.parseInt(age));
//        contact.setGender(gender);
//        contact.setPhone(phone);
//        System.out.println(contact);
//        //3.调用dao类的添加联系人方法
//        ContactDao dao = new ContactDaoImpl();
//        try {
//            dao.addContact(contact);
//        } catch (DocumentException | IOException e) {
//            e.printStackTrace();
//        }
//        //4.跳转到查询所有联系人页面
//        response.sendRedirect(request.getContextPath()+"/ServletListContact");
//    }
}
