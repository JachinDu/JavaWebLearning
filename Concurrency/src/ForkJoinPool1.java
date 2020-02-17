import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/14 10:17
 */

public class ForkJoinPool1 {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());

    }


    // 无返回值，类似与runnable
    //    static class AddTask extends RecursiveAction {
//
//        int start,end;
//
//        public AddTask(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        protected void compute() {
//            if (end - start <= MAX_NUM) {
//                long sum = 0;
//                for (int i = start; i < end; i++) {
//                    sum += nums[i];
//                }
//                System.out.println("from " + start + " to " + end + " = " + sum);
//            } else {
//                int middle = start + (end - start) / 2;
//                AddTask subTask1 = new AddTask(start, middle);
//                AddTask subTask2 = new AddTask(middle, end);
//                subTask1.fork();
//                subTask2.fork();
//            }
//        }
//    }
    // 有返回值，类似于callable
    static class AddTask extends RecursiveTask<Long> {
        int start,end;
//
        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
//                System.out.println("from " + start + " to " + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
                return subTask1.join() + subTask2.join();  // 整合结果
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        fjp.execute(task);
        Long res = task.join();  // join()本身就是阻塞的，所以无需额外执行阻塞
        System.out.println(nums);
//        System.in.read();
    }
}
