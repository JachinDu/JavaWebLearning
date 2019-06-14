import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

//完整的读取xml文件内容
public class Demo3 {

    @Test
    public void test() throws DocumentException {

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        Element rootElem = doc.getRootElement();
        StringBuffer sb = new StringBuffer();
        getChildNodes(rootElem,sb);
        System.out.println(sb.toString());
    }

    //获取当前标签子标签
    private void getChildNodes(Element element,StringBuffer sb) {
        //System.out.println(element.getName());

        //得到标签的属性列表
        sb.append("<" + element.getName());
        List<Attribute> attrs = element.attributes();
        if (attrs != null) {
            for (Attribute attr : attrs) {
                //System.out.println(attr.getName() + "=" + attr.getValue());
                sb.append(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
            }
        }
        sb.append(">");

        //得到文本
//        String content = element.getText();
//        sb.append(content);
        //System.out.println(content);

        Iterator<Node> nodeIterator = element.nodeIterator();
        while(nodeIterator.hasNext()){
            Node node = nodeIterator.next();
            //标签
            if (node instanceof Element) {
                Element el = (Element)node;
                getChildNodes(el,sb);
            }
            //文本
            if (node instanceof Text) {
                Text text = (Text)node;
                sb.append(text.getText());
            }
        }

        sb.append("</" + element.getName() + ">");
    }


}
