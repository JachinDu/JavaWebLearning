import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/06 13:19
 */

public class RunnableTask1 implements Runnable {
    private volatile int[] arr = new int[20];

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arr[19] = 2;
    }
}
