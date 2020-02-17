import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/06 13:14
 */

public class TestVolatile {

    public static long[] arr = new long[20];
    private volatile int i = 0;
    private int[] array = new int[20];

    public static void main(String[] args) throws Exception {
        TestVolatile tv = new TestVolatile();
        //线程1
        new Thread(new Thread(){
            @Override
            public void run() {
                //Thread A
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                tv.array[19] = 2;
                tv.i = 1;
                try {
                    TimeUnit.MILLISECONDS.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束！");
            }
        }).start();


        //线程2
        new Thread(new Thread(){
            @Override
            public void run() {
                //Thread B
                while (tv.i != 1) {
                    System.out.println("looping.....");
                }
                System.out.println("Jump out of the loop!");
            }
        }).start();
    }
}
