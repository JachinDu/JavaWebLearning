package com.com.imooc;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/*
 *实现用户登陆
 */
public class Server {
    public static void main(String[] args)
    {

        try {
            //1.创建服务器Socket，指定绑定端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            //记录客户端数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端链接***");

            //循环侦听，等待客户端连接
            while(true){
                //2.监听，等待客户链接
                socket = serverSocket.accept();
                //创建一个线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端数量：" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端IP：" + address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
