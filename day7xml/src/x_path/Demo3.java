package x_path;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
 * 模拟用户登陆
 * */
public class Demo3 {
    public static void main(String[] args) throws IOException, DocumentException {
        //1.获取用户输入的用户名和密码
        //System.in：系统字节流
        //InputStreamReader()：字节流转换为字符流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name = br.readLine();

        System.out.println("请输入密码：");
        String password = br.readLine();

        //2.到"数据库"中查询是否有对应的用户
        //对应的用户：在user.xml中找到一个一个name和password对应用户所输入的
        Document doc = new SAXReader().read(new File("./src/user.xml"));
        //将变量插入字符串中
        Element userElem = (Element) doc.selectSingleNode("//user[@name='" +name+ "' and @password='" +password+ "']");
        if (userElem != null) {
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }

    }

}
