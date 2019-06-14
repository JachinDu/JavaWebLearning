package com.a_dom4j_read_pkg;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class Demo1 {
    public static void main(String[] args) {
        //1.创建一个xml解析器对象
        SAXReader reader = new SAXReader();
        //2.读取xml文档，返回Document对象
        Document doc = null;
        try {
            doc = reader.read(new File("./src/contact.xml"));
            System.out.println(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
