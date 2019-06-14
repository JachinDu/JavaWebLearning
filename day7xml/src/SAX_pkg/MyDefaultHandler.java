package SAX_pkg;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
* SAX处理程序（如何解析xml文档）
*
* */

public class MyDefaultHandler extends DefaultHandler {

    //开始文档时调用
    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler.startDocument()");
    }

    //结束文档时调用
    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler.endDocument()");
    }

    //开始标签时调用
    //参数：qName：表示开始标签的标签名
    //     attributes：表示开始标签内包含的属性列表

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler.startElement()-->"+qName);
    }

    //结束标签时调用
    //参数：qName：表示结束标签的标签名
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("MyDefaultHandler.endElement()-->"+qName);
    }

    //读到文本内容时调用
    //参数：ch:表示当前读完的所有xml文本内容
    //     start：当前文本内容开始位置
    //     length：当前文本内容长度
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       //得到当前文本内容(利用参数）
        String content = new String(ch, start, length);
        System.out.println("MyDefaultHandler.characters()-->" + content);
    }
}
