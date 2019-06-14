package com.a_dom4j_read_pkg;

//读xml内容

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
    @Test
    public void test1() throws DocumentException {

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));
        //1.nodeIterator()：得到当前节点下的所有子节点对象（不包括孙节点以下）
        Iterator<Node> it = doc.nodeIterator();
        //Iterator it = doc.nodeIterator();
        while(it.hasNext()){
            Node node = it.next();
            //Object node = it.next();
            String name = node.getName();
            System.out.println(name);

            //继续取出下面的子节点
            //只有标签节点才有子节点，属性和文本节点没有子节点
            if(node instanceof Element){
                Element element = (Element)node;
                Iterator<Node> it2 = element.nodeIterator();
                while(it2.hasNext()){
                    Node n2 = it2.next();
                    System.out.println(n2.getName());
                }
            }

        }
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        Element rootElem = doc.getRootElement();
        getChildNode(rootElem);
    }

    //获取传入标签下所有子节点
    private void getChildNode(Element element){
        System.out.println(element.getName());

        //得到子节点
        Iterator<Node> it = element.nodeIterator();
        while(it.hasNext()){
            Node node = it.next();

            //1.判断是否是标签节点
            if(node instanceof Element){
                Element element1 = (Element)node;
                //2.递归
                getChildNode(element1);
            }
        }
    }

    @Test
    public void test3() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        //得到根标签
        Element rootElement = doc.getRootElement();
        //得到标签名称
        String name = rootElement.getName();
        System.out.println(name);

        //得到当前标签下的第一个指定名字的子标签
//        Element contactElement = rootElement.element("contact");
//        System.out.println(contactElement.getName());

        //得到当前标签下指定名称的所有子标签
//        Iterator<Element> it = rootElement.elementIterator("contact");
//        while(it.hasNext()){
//            Element element = it.next();
//            System.out.println(element.getName());
//        }
//
//        //得到当前标签下的所有子标签
//        List<Element> list = rootElement.elements();
//        for(Element e:list){
//            System.out.println(e.getName());
//        }
        //获取更深层的标签只能一层层获取
        Element nameElem = doc.getRootElement().element("contact").element("name");
        System.out.println(nameElem.getName());

    }


    @Test
    public void test4() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        //方法一：
        //1.1、先获取属性所在标签
        Element contactElem = doc.getRootElement().element("contact");
        //1.2、得到属性
//        String idValue = contactElem.attributeValue("id");
//        System.out.println(idValue);

        //方法二：
        //2.1、得到属性对象
//        Attribute idAttr = contactElem.attribute("id");
//        //2.2、getName()：属性名称    getValue()：属性值
//        System.out.println(idAttr.getName() + " = " + idAttr.getValue());

        //得到所有属性对象
        List<Attribute> list = contactElem.attributes();
        for(Attribute attr:list){
            System.out.println(attr.getName() + " = " + attr.getValue());
        }

    }

    @Test
    public void test5() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("./src/contact.xml"));

        //先获取标签再获取对应标签的文本
        Element nameElem = doc.getRootElement().element("contact").element("name");
        //得到文本
        String text = nameElem.getText();
        System.out.println(text);

        //拿指定子标签的文本
        String text2 = doc.getRootElement().element("contact").elementText("name");
        System.out.println(text2);

    }
}
