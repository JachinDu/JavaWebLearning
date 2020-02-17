import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/06 20:39
 */

public class Synchornized implements Runnable{
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("Thread: " + Thread.currentThread().getName() + " ,count: " + count);
    }
}
