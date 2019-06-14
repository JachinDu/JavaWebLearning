package contact_day10;

/*
* 联系人操作实现的测试类
* */

import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestContactOperatorImpl {

    ContactOperator operator = null;

    @Before
    public void init() {
        operator = new ContactOperatorImpl();
    }

    @Test
    public void testAddContact() throws IOException, DocumentException {
        Contact contact = new Contact();
        contact.setId("2");
        contact.setName("eric");
        contact.setGender("男");
        contact.setAge(20);
        contact.setPhone("13288888");
        contact.setEmail("eric@aq.com");
        contact.setQq("111114444");
        operator.addContact(contact);


    }
    @Test
    public void testUpdateContact() throws IOException, DocumentException {
        Contact contact = new Contact();
        contact.setId("2");
        contact.setName("jiacfdfd");
        contact.setGender("男");
        contact.setAge(22);
        contact.setPhone("188");
        contact.setEmail("eric@aq.com");
        contact.setQq("111114444");
        operator.updateContact(contact);
    }

    @Test
    public void testDeleteContact() throws DocumentException, IOException {
        operator.deleteContact("2");
    }

    @Test
    public void testFindAll() throws DocumentException {
        List<Contact> list = operator.findAll();
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }
}
