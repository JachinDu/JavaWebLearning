package day12.contact.service.impl;

import day12.contact.dao.ContactDao;
import day12.contact.dao.impl.ContactDaoImpl;
import day12.contact.dao.impl.ContactDaoMySQLImpl;
import day12.contact.entity.Contact;
import day12.contact.exception.NameRepeatException;
import day12.contact.service.ContactService;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
/*
* service层，无特殊方法就调用dao的方法
* */
public class ContactServiceImpl implements ContactService {
//    ContactDao dao = new ContactDaoImpl();
    ContactDao dao = new ContactDaoMySQLImpl();
    @Override
    public void addContact(Contact contact) throws DocumentException, IOException, NameRepeatException {
        //执行业务逻辑判断
        if (dao.checkContact(contact.getName())) {
            //重复
            /*
            * 业务层方法出现任何异常，要返回标记（自定义异常）到servlet，
            * */
            throw  new NameRepeatException("姓名重复，不可使用！");
        }

        dao.addContact(contact);
    }

    @Override
    public void modifyContact(Contact contact) throws DocumentException, IOException {
        dao.modifyContact(contact);
    }

    @Override
    public void deleteContact(String id) throws DocumentException, IOException {
        dao.deleteContact(id);
    }

    @Override
    public List<Contact> findAll() throws DocumentException {
        return dao.findAll();
    }

    @Override
    public Contact findById(String id) throws DocumentException {
        return dao.findById(id);
    }
}
