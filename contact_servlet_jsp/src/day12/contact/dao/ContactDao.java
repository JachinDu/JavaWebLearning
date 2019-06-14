package day12.contact.dao;

import day12.contact.entity.Contact;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact) throws DocumentException, IOException;

    public void modifyContact(Contact contact) throws DocumentException, IOException;

    public void deleteContact(String id) throws DocumentException, IOException;

    public List<Contact> findAll() throws DocumentException;

    public Contact findById(String id) throws DocumentException;
}
