package day12.contact.test;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.entity.Contact;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestContactOperatorImpl {
    ContactDao operator = null;

    @Before
    public void init() {
        operator = new ContactDaoImpl();
    }

    @Test
    public void testAddContact() throws IOException, DocumentException {
        Contact contact = new Contact();
        //contact.setId("2");
        contact.setName("eeee");
        contact.setGender("男");
        contact.setAge(20);
        contact.setPhone("13288888");
        operator.addContact(contact);


    }

    @Test
    public void testModifyContact() throws IOException, DocumentException {
        Contact contact = new Contact();
        contact.setId("2");
        contact.setName("jiacfdfd");
        contact.setGender("男");
        contact.setAge(22);
        contact.setPhone("188");
        operator.modifyContact(contact);
    }

    @Test
    public void testDeleteContact() throws DocumentException, IOException {
        operator.deleteContact("2");
    }

    @Test
    public void testFindAll() {
        List<Contact> list = null;
        try {
            list = operator.findAll();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

    @Test
    public void testFindById() throws DocumentException {
        Contact contact = operator.findById("2");
        System.out.println(contact);
    }
}
