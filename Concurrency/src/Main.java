import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/06 20:37
 */


public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap
        Atomic at = new Atomic();
        Synchornized sd = new Synchornized();
        List<Thread> threads1 = new ArrayList<>();
        List<Thread> threads2 = new ArrayList<>();
        ExecutorService pool1 = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        ExecutorService pool2 = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            pool1.execute(at);
        }

        pool1.shutdown();  // 线程池中所有线程都执行完任务后才会执行
        while (true) {
            if (pool1.isTerminated()) {
                long time = System.currentTimeMillis() - start1;
                System.out.println("程序1结束了，总耗时：" + time + " ms(毫秒)！\n");
                break;
            }
        }

        Long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            pool2.execute(sd);
        }

        pool2.shutdown();
        while (true) {
            if (pool2.isTerminated()) {
                long time = System.currentTimeMillis() - start2;
                System.out.println("程序2结束了，总耗时：" + time + " ms(毫秒)！\n");
                break;
            }
        }
    }

}
