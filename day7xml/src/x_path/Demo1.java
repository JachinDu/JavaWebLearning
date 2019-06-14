package x_path;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws DocumentException, IOException {
        /*
        *
        * 需求：删除id为2的学生标签
        * */
        Document doc = new SAXReader().read(new File("./src/student.xml"));

        //1.查询id为2的学生标签
        Element stuElem = (Element) doc.selectSingleNode("//Student[@id='2']");
       //2.删除标签
        stuElem.detach();

        //3.写出内容
        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/student.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();

    }
}
