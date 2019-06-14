package day12.contact.dao.impl;

import day12.contact.dao.ContactDao;
import day12.contact.entity.Contact;
import day12.contact.util.XMLUti;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDaoImpl implements ContactDao {
    @Override
    public void addContact(Contact contact) throws DocumentException, IOException {
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

        /*
        * 由系统自动随机生成唯一ID，赋给联系人
        * */
        String uuid = UUID.randomUUID().toString().replace("-","");

        contactElem.addAttribute("id",uuid);
        contactElem.addElement("name").setText(contact.getName());
        contactElem.addElement("gender").setText(contact.getGender());
        contactElem.addElement("age").setText(contact.getAge()+"");//int 转 String简便方法
        contactElem.addElement("phone").setText(contact.getPhone());


        //把Document写出到xml
        XMLUti.write2xml(doc);
    }

    @Override
    public void modifyContact(Contact contact) throws DocumentException, IOException {
        //1.读取xml文件
        Document doc = XMLUti.getDocument();
        Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
        //2.修改contact标签内容
        contactElem.element("name").setText(contact.getName());
        contactElem.element("gender").setText(contact.getGender());
        contactElem.element("age").setText(contact.getAge()+"");
        contactElem.element("phone").setText(contact.getPhone());

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
        List<Contact> list = null;
        try {
            //1.读去xml
            Document doc = XMLUti.getDocument();
            //2.创建List对象
            list = new ArrayList<Contact>();
            //3.读取所有contact
            List<Element> conList = (List<Element>)doc.selectNodes("//contact");
//        List<Element> conList = (List<Element>)doc.selectNodes("//contact");
            for (Element e : conList) {
                //创建Contact对象
                Contact c = new Contact();
                c.setId(e.attributeValue("id"));
                c.setName(e.elementText("name"));
                c.setAge(Integer.parseInt(e.elementText("age")));
                c.setGender(e.elementText("gender"));
                c.setPhone(e.elementText("phone"));
                list.add(c);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Contact findById(String id) throws DocumentException {
        Document doc = XMLUti.getDocument();
        Element e = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
        Contact c = null;
        if (e != null) {
            //创建Contact对象
            c = new Contact();
            c.setId(e.attributeValue("id"));
            c.setName(e.elementText("name"));
            c.setAge(Integer.parseInt(e.elementText("age")));
            c.setGender(e.elementText("gender"));
            c.setPhone(e.elementText("phone"));
        }
        return c;
    }

//    public static void main(String[] args) {
//        //测试UUID
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        System.out.println(uuid);
//    }



    /*
    * true:重复
    * false:不重复
    * */
    @Override
    public boolean checkContact(String name) throws DocumentException {
        Document doc = XMLUti.getDocument();
        Element nameElem = (Element) doc.selectSingleNode("//name[text()='" + name + "']");//xpath
        if (nameElem != null) {
            return true;
        } else {
            return false;
        }
    }
}
