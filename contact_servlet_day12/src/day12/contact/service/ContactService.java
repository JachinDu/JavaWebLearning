package day12.contact.service;

import day12.contact.entity.Contact;
import day12.contact.exception.NameRepeatException;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public interface ContactService {
    public void addContact(Contact contact) throws DocumentException, IOException, NameRepeatException;

    public void modifyContact(Contact contact) throws DocumentException, IOException;

    public void deleteContact(String id) throws DocumentException, IOException;

    public List<Contact> findAll() throws DocumentException;

    public Contact findById(String id) throws DocumentException;
}
