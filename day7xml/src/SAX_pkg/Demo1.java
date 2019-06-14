package SAX_pkg;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //1.创建SAXParser对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        //2.调用parse方法
        parser.parse(new File("./src/contact.xml"), new MyDefaultHandler());
    }
}
