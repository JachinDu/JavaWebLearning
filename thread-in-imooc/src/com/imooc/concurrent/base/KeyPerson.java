package com.imooc.concurrent.base;


public class KeyPerson extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() + "开始战斗！");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + "左突右杀，进攻隋军！");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗！");

    }
}
