package contact_day10;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import sun.tools.jstat.OutputFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* 实现联系人操作接口
* */

public class ContactOperatorImpl implements ContactOperator {
    @Override
    public void addContact(Contact contact) throws IOException, DocumentException {
        /*
        * 把contact对象保存到xml文件中*/
        //如果没有xml文件，则创建文件，否则读取文件
        File file = new File("/Users/jc/Desktop/contact.xml");
        Document doc = null;
        Element rootElem = null;
        if (!file.exists()) {
            doc = DocumentHelper.createDocument();
            //创建根标签
            rootElem = doc.addElement("contactList");
        } else {
            doc = new SAXReader().read(file);
            rootElem = doc.getRootElement();
        }



        //添加contact标签
        /*
        *  <contact id="001">
            <name>章三</name>
            <age>20</age>
            <phone>333333333</phone>
            <email>kjofjw@jidja.com</email>
            <qq>21214432432</qq>
          </contact>
        * */
        Element contactElem = rootElem.addElement("contact");
        contactElem.addAttribute("id",contact.getId());
        contactElem.addElement("name").setText(contact.getName());
        contactElem.addElement("gender").setText(contact.getGender());
        contactElem.addElement("age").setText(contact.getAge()+"");//int 转 String简便方法
        contactElem.addElement("phone").setText(contact.getPhone());
        contactElem.addElement("email").setText(contact.getEmail());
        contactElem.addElement("qq").setText(contact.getQq());

        //把Document写出到xml
        XMLUti.write2xml(doc);
    }

    @Override
    public void updateContact(Contact contact) throws DocumentException, IOException {
        //1.读取xml文件
        Document doc = XMLUti.getDocument();
        Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
        //2.修改contact标签内容
        contactElem.element("name").setText(contact.getName());
        contactElem.element("gender").setText(contact.getName());
        contactElem.element("age").setText(contact.getAge()+"");
        contactElem.element("phone").setText(contact.getPhone());
        contactElem.element("email").setText(contact.getEmail());
        contactElem.element("qq").setText(contact.getQq());

        //3.把Document写出到xml
        XMLUti.write2xml(doc);
    }

    @Override
    public void deleteContact(String id) throws DocumentException, IOException {
        Document doc = XMLUti.getDocument();
        Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
        contactElem.detach();
        XMLUti.write2xml(doc);
    }

    @Override
    public List<Contact> findAll() throws DocumentException {
        //1.读去xml
        Document doc = XMLUti.getDocument();
        //2.创建List对象
        List<Contact> list = new ArrayList<Contact>();
        //3.读取所有contact
        List<Element> conList = (List<Element>)doc.selectNodes("//contact");
        for (Element e : conList) {
            //创建Contact对象
            Contact c = new Contact();
            c.setId(e.attributeValue("id"));
            c.setName(e.elementText("name"));
            c.setAge(Integer.parseInt(e.elementText("age")));
            c.setGender(e.elementText("gender"));
            c.setPhone(e.elementText("phone"));
            c.setEmail(e.elementText("email"));
            c.setQq(e.elementText("qq"));
            list.add(c);
        }
        return list;
    }
}
