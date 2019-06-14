package dom4j_write;

//修改xml内容

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;

public class Demo3 {

    @Test  //增加文本，标签，属性
    public void test1() throws IOException {

        //1、创建文档
        Document doc = DocumentHelper.createDocument();
        //2、增加标签
        Element rootElem = doc.addElement("contactList");  //这里是根标签，直接doc.addElement只能有一个
        Element contactElem = rootElem.addElement("contact");
        contactElem.addElement("name");
        //3、增加属性
        contactElem.addAttribute("id", "001");



        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行


        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

    //修改属性，文本
    @Test
    public void test2() throws DocumentException, IOException {
        Document doc = new SAXReader().read(new File("./src/contact.xml"));

        //修改属性：方案一
        //1、得到标签对象。
//        Element contactElem = doc.getRootElement().element("contact");
//        //2、得到属性对象。
//        Attribute idAddr = contactElem.attribute("id");
//        //3、修改属性值
//        idAddr.setValue("003");
//
//        //////////////////////////////////////////////
//        //修改属性：方案二
//        //1、得到标签对象
//        Element contactElem = doc.getRootElement().element("contact");
//        //2、通过增加同名属性的方法，修改属性值（覆盖）
//        contactElem.addAttribute("id", "004");

        //修改文本：
        //1、得到标签对象
        Element nameElem = doc.getRootElement().element("contact").element("name");
        //2、修改文本
        nameElem.setText("加成");

        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

    //删除：标签，属性
    @Test
    public void test3() throws DocumentException, IOException {
        Document doc = new SAXReader().read(new File("./src/contact.xml"));

        //删除标签：
        //1、得到标签对象
        Element ageElem = doc.getRootElement().element("contact").element("age");
        //2、删除标签
        //ageElem.detach(); //1
        ageElem.getParent().remove(ageElem);//2

        //////////////////////////////////////////////
        //删除属性：
        //1、得到属性对象(得到第二个contact的标签
        Element contactElem = (Element) doc.getRootElement().elements().get(1);
        //2.得到属性对象
        Attribute idAttr = contactElem.attribute("id");
        //3.删除属性
        idAttr.detach(); //1
        //idAttr.getParent().remove(idAttr);//2

        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

}
