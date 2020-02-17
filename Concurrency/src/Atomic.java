import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/06 20:38
 */

public class Atomic implements Runnable{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Thread: " + Thread.currentThread().getName() + " ,count: " + count);
    }
}
