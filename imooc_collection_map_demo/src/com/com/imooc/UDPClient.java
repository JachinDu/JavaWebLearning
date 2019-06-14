package com.com.imooc;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;

/*
 * 客户端
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //1.定义服务器地址，端口号，数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名：admin；密码：123".getBytes();
        //2.创建数据报
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4.向服务器发送数据报
        socket.send(packet);


        /*
         * 接收服务器端的响应数据
         */
        //1.创建数据报，用于接收服务器响应数据
        byte[] data1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data1,data1.length);
        //2.接收服务器响应的数据
        socket.receive(packet1);
        //3.读取数据
        String reply = new String(data1,0,packet1.getLength());
        System.out.println("我是客户端，服务器说：" + reply);
        //4.关闭资源
        socket.close();
    }
}
