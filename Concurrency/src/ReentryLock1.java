import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/08 16:46
 */

public class ReentryLock1 {

    Lock lock = new ReentrantLock();

    void m1() {
        try {
            lock.lock();
            for (int i = 0; i < 4; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " m1 " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2() {
//        boolean locked = false;

        try {
//            locked = lock.tryLock(5,TimeUnit.SECONDS);// 就算在第一秒就获取到锁了，也要等到5s后再继续
            lock.lockInterruptibly();  // 外部可打断该线程的等待
            System.out.println("t2 start");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("t2 end");

//            System.out.println(Thread.currentThread().getName() + " m2...." + locked);
        } catch (InterruptedException e) {
            System.out.println("Interrupted! t2");
        } finally {
            try {
                lock.unlock();
            } catch (Exception e) {
                System.out.println("no lock to unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentryLock1 r1 = new ReentryLock1();
        new Thread(r1::m1, "thread1").start();
        Thread t2 = new Thread(r1::m2,"thread2");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }
}
