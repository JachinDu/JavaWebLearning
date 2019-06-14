package com.imooc.concurrent.base;

//军队线程
public class ArmyRunnable implements Runnable {

    //volatile保证了线程可以正确读取其他线程写入的值
    volatile boolean keepRunning = true;

    public void run(){
        while(keepRunning){
            //发送5连攻击
            for(int i = 0; i < 5; i++)
            {
                System.out.println(Thread.currentThread().getName() + "进攻对方["+i+"]");

                //让出了处理器时间，下次谁进攻还不一定
                Thread.yield();
            }

        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗！");
    }
}
