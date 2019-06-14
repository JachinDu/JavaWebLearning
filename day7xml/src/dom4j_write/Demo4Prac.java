package dom4j_write;

/*
* 实现一个student.xml文件的创建及修改
* */

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Demo4Prac {
    public static void main(String[] args) throws IOException {
        //创建文档
        Document doc = DocumentHelper.createDocument();
        //添加标签
        Element rootELem = doc.addElement("Students");
        Element stu1ELem = rootELem.addElement("Student");
        Element stu2ELem = rootELem.addElement("Student");
//        Element stu1Elem = (Element) rootELem.elements().get(0);
//        Element stu2Elem = (Element) rootELem.elements().get(1);

        Element nameElem1 = stu1ELem.addElement("name");
        Element genderElem1 = stu1ELem.addElement("gender");
        Element gradeElem1 = stu1ELem.addElement("grade");
        Element addrElem1 = stu1ELem.addElement("address");

        Element nameElem2 = stu2ELem.addElement("name");
        Element genderElem2 = stu2ELem.addElement("gender");
        Element gradeElem2 = stu2ELem.addElement("grade");
        Element addrElem2 = stu2ELem.addElement("address");

        //添加属性

        stu1ELem.addAttribute("id", "1");
        stu2ELem.addAttribute("id","2");

        //添加文本
        nameElem1.setText("张三");
        genderElem1.setText("男");
        gradeElem1.setText("计算机1班");
        addrElem1.setText("广州天河");

        nameElem2.setText("李四");
        genderElem2.setText("女");
        gradeElem2.setText("计算机2班");
        addrElem2.setText("广州越秀");


        //修改id为2的学生姓名
//        List<Element> list = rootELem.elements();
//        for (Element e : list) {
//            String idValue = e.attributeValue("id");
//            if (idValue == "2") {
//                e.element("name").setText("王丽");
//            }
//        }

        //删除id为2的学生
//        List<Element> list = rootELem.elements();
//        for (Element e : list) {
//            String idValue = e.attributeValue("id");
//            if (idValue == "2") {
//                e.detach();
//            }
//        }



        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/student.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();

    }
}
