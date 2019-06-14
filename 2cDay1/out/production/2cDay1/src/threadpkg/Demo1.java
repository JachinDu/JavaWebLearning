package threadpkg;

//public class Demo1 extends Thread{
//
//    public Demo1(String name){
//        super(name);
//    }
//    @Override
//    public void run() {
//        for(int i = 0; i < 100; i++){
//            System.out.println(Thread.currentThread().getName()+":"+i);
//        }
//    }
//
//    public static void main(String[] args) {
//        Demo1 d = new Demo1("狗娃");
//        d.start();
//
//        for(int i = 0; i < 100; i++){
//            System.out.println(Thread.currentThread().getName()+":"+i);
//        }
//    }
//}

public class Demo1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        Thread thread = new Thread(d);
        thread.start();

        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+":::"+i);
        }
    }

}
