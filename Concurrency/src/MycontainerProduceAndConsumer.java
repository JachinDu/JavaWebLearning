import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 生产者/消费者代码
 * @Author: JachinDo
 * @Date: 2019/11/08 19:48
 */

public class MycontainerProduceAndConsumer<T> {
    private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    // condition实现了自定义线程唤醒, 要配合ReentrantLock

    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        lock.lock();
        try {
            while (list.size() == MAX) {
                producer.await();  // 该线程在producer这个类别的condition下等待，以便后面可以统一唤醒
            }
            list.add(t);
            count++;
            consumer.signalAll();  // 通知所有消费者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        lock.lock();
        try {
            while (list.size() == 0){
            consumer.await(); // 同上producer.await()
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();  // 通知所有生产者
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MycontainerProduceAndConsumer<String> c = new MycontainerProduceAndConsumer<>();

        // 启动消费者线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }

    }
}
