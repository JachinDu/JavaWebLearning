package day8_server;

/*
* socket服务端
* */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务器启动成功.....");

        //2.接受客户端的连接
        Socket socket = serverSocket.accept();

        //3.读取本地test.html文件
        FileInputStream in = new FileInputStream(new File("/Users/jc/IdeaProjects/day08/src/day8_server/test.html"));

        //4.构建数据输出通道
        OutputStream out = socket.getOutputStream();

        //5.发送数据
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {  //读到末尾返回-1
            String x = new String(buf, 0, len);
            System.out.println(x);
            out.write(buf,0,len);   //将读取的内容写到输出通道
            System.out.println("发送了");
        }

        //6.关闭资源
        out.close();
        in.close();
        System.out.println("dddd");

    }
}
