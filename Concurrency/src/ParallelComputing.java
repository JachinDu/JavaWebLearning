import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/13 20:57
 */


class MyTask implements Callable<List<Integer>> {
    int start;
    int end;

    public MyTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() throws Exception {
        ParallelComputing pc = new ParallelComputing();
        return pc.getPrime(start,end);
    }
}

public class ParallelComputing {
    static final int cpuCoreNum = 4;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ParallelComputing pc = new ParallelComputing();
        List<Integer> result = pc.getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println("one thread: " + (end - start));

        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();

        end = System.currentTimeMillis();
        System.out.println("mutiple thread: " + (end - start));
        service.shutdown();

    }

    public boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getPrime(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }
}
