package x_path;
/*
*
* 学习xpath语法
* */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws DocumentException {
        Document doc = new SAXReader().read(new File("./src/contact.xml"));

        String xpath = "";
        xpath = "/contactList";
        xpath = "/contactList/contact";

        xpath = "//contact/name";
        xpath = "//name";

        xpath = "/contactList/*";
        xpath = "/contactList//*";

        xpath = "//contact[@id]";
        xpath = "//contact[2]";
        xpath = "//contact[last()]";

        xpath = "//@id";  //选属性对象,不是标签对象
        xpath = "//contact[not(@id)]"; //选择不包含id属性的标签
        xpath = "//contact[@id='002']";
        xpath = "//contact[@id='001' and @name='eric']";  //返回Text对象

        xpath = "//name/text()";
        xpath = "//contact/name[text()='张三']";
        List<Node> list = doc.selectNodes(xpath);
        for (Node node : list) {
            System.out.println(node);
        }
    }
}
