package com.imooc.concurrent.base;


/*
 * 隋唐舞台
 */
public class Stage extends Thread {

    public void run(){

        System.out.println("欢迎观看演出！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大幕徐徐拉开！");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠，专心观看军队作战
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出个程咬金！");
        Thread mrCheng = new KeyPerson();
        mrCheng.setName("程咬金");

        System.out.println("程咬金理想结束战争，安居乐业！");

        //停止军队作战，停止线程的方法
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*
            历史大戏留给关键人物
         */
        mrCheng.start();

        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束！！！！！！");
        System.out.println("演出结束！！");

    }



    public static void main(String[] args)
    {
        new Stage().start();
    }
}
