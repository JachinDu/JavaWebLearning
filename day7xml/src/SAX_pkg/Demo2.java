package SAX_pkg;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/*
* 读取contact.xml文件，完整输出文档内容
* */
public class Demo2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.创建SAXParser
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        //2.读取xml
        MyDefaultHandler2 handler = new MyDefaultHandler2();
        parser.parse(new File("./src/contact.xml"),handler);
        String content = handler.getContent();
        System.out.println(content);
    }
}
