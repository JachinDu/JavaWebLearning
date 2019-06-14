package cn.itcast.junit;

import org.junit.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo2 {

    @BeforeClass
    public static void beforeRead(){
        System.out.println("准备测试环境成功。。。");
    }

    @Test
    public void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/jc/Desktop/a.txt");
        int content = fileInputStream.read();
        System.out.println("内容："+ content);
    }

    @Test
    public void sort(){
        System.out.println("数据排序");
    }

    @AfterClass
    public static void afterRead(){
        System.out.println("清理测试环境。。。");
    }
}
