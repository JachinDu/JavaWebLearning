package com.com.imooc;

/*
    服务器线程处理类
 */

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    //和本线程相关的Socket
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;

    }
    //线程执行操作，响应客户端请求
    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;


        try{
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是服务器，客户端说：" + info);
            }
            socket.shutdownInput();//关闭输入流

            //获取输出流，响应客户端请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);//包装为打印流
            pw.write("欢迎你！");
            pw.flush();


        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(pw!=null)
                pw.close();
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr!=null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
