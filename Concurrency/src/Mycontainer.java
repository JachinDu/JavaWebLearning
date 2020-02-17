import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/08 15:22
 */


public class Mycontainer {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Mycontainer container = new Mycontainer();
        CountDownLatch latch = new CountDownLatch(1);


        // lambda创建线程的方式简洁
        new Thread(() -> {
            if (container.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "'s notifyTo5");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (container.size() == 5) {
                    latch.countDown();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                container.add(new Object());
                System.out.println(Thread.currentThread().getName() + " add " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"thread1").start();
    }
}
