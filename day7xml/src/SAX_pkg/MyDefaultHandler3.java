package SAX_pkg;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyDefaultHandler3 extends DefaultHandler {
    //存储所有联系人对象
    private List<Contact> list = new ArrayList<Contact>();

    public List<Contact> getList() {
        return list;
    }

    private Contact contact;  //保存一个联系人对象

    private String curTag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        curTag = qName;
        if(qName == "contact"){
            contact = new Contact();
            contact.setId(attributes.getValue("id")); //获取指定名称的属性
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);

        if (curTag == "name") {
            contact.setName(content);
        }
        if (curTag == "age") {
            contact.setAge(content);
        }
        if (curTag == "phone") {
            contact.setPhone(content);
        }
        if (curTag == "email") {
            contact.setEmail(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //置空是为了避免空格换行设置到对象属性中
        curTag = null;

        //读到contact结束标签就放入list中
        if (qName == "contact") {
            list.add(contact);
        }
    }
}
