package com.com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
    public static void main(String[] args)
    {
        try {
            URL imooc = new URL("http://wwww.imooc.com");
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            System.out.println("端口：" + url.getPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
