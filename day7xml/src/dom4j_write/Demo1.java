package dom4j_write;

import jdk.internal.util.xml.XMLStreamException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

//写内容到xml文档
public class Demo1 {

    public static void main(String[] args) throws IOException, XMLStreamException, DocumentException {

        //读取day7项目里的xml文件
        Document doc = new SAXReader().read(new File("./src/contact.xml"));

        //指定文件输出位置
        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");

        //1.创建写出对象
        XMLWriter writer = new XMLWriter(out);

        //2.写出对象
        writer.write(doc);
        //3.关闭流
        writer.close();
    }
}
