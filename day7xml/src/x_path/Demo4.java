package x_path;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/*
* 使用xpath读取一个规范的html文档
* */
public class Demo4 {
    public static void main(String[] args) throws DocumentException {
        Document doc = new SAXReader().read(new File("./src/personList.html"));
//        System.out.println(doc);
//
//        //读取title标签
//        Element titleElem = (Element) doc.selectSingleNode("//title");
//        String title = titleElem.getText();
//        System.out.println(title);

        //特定格式输出personList.html中的信息：
            //编号:001 姓名:张三 性别:男 年龄:18 地址:xxxxx 电话:kkkkkkk
        //1.先读取所有tr标签,注意类型转换
        List<Element> list = (List<Element>) doc.selectNodes("//tbody/tr");
        for (int i = 0; i < list.size(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(" 编号：");
            Element numElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[1]");
            sb.append(numElem.getText());
            sb.append(" 姓名：");
            Element nameElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[2]");
            sb.append(nameElem.getText());
            sb.append(" 性别：");
            Element genderElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[3]");
            sb.append(genderElem.getText());
            sb.append(" 年龄：");
            Element ageElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[4]");
            sb.append(ageElem.getText());
            sb.append(" 地址：");
            Element addrElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[5]");
            sb.append(addrElem.getText());
            sb.append(" 电话：");
            Element phoneElem = (Element) doc.selectSingleNode("//tbody/tr["+i+"+1]/td[6]");
            sb.append(phoneElem.getText());
            System.out.println(sb.toString());
        }

    }
}
