package contact_day10;

import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/*
* 该接口存放对联系人相关操作对方法
* */
public interface ContactOperator {
    public void addContact(Contact contact) throws IOException, DocumentException;//增加
    public void updateContact(Contact contact) throws DocumentException, IOException;//修改
    public void deleteContact(String id) throws DocumentException, IOException;//删除
    public List<Contact> findAll() throws DocumentException;//查询所有联系人
}
