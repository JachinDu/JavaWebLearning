import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo4 {

    public static void main(String[] args) throws DocumentException {
        List<Contact> list = new ArrayList<Contact>();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        //读取contact标签
        Iterator<Element> it = doc.getRootElement().elementIterator("contact");
        while (it.hasNext()) {
            Element elem = it.next();
            Contact contact = new Contact();
            contact.setId(elem.attributeValue("id"));
            contact.setName(elem.elementText("name"));
            contact.setAge(elem.elementText("age"));
            contact.setPhone(elem.elementText("phone"));
            contact.setEmail(elem.elementText("email"));
            list.add(contact);
        }

        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
