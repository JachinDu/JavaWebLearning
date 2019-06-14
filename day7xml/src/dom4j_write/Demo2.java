package dom4j_write;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

//写出内容到xml文件细节
public class Demo2 {
    public static void main(String[] args) throws IOException, DocumentException {

        Document doc = new SAXReader().read(new File("./src/contact.xml"));
        //指定文件输出位置
        FileOutputStream out = new FileOutputStream("/Users/jc/Desktop/contact.xml");

        //1.指定写出格式
        //OutputFormat format = OutputFormat.createCompactFormat();  //紧凑格式,去除空格和换行
        OutputFormat format = OutputFormat.createPrettyPrint();  //漂亮格式，有空格和换行


        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();


    }
}
