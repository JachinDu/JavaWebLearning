package com.com.imooc;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args)
    {

        try {
            //1.创建客户端socket，指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2.获取输出流，向服务端发送登陆信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
            pw.write("用户名：tom; 密码：456");
            pw.flush();
            socket.shutdownOutput();

            //3.获取输入流，获取服务端响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器说：" + info);
            }

            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
