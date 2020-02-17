import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/13 20:44
 */

public class Future_1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> task = new FutureTask<>( () -> {
//            TimeUnit.SECONDS.sleep(3);
//            return 1000;
//        });

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return 1000;
            }
        });
        new Thread(task).start();
        System.out.println(task.get());
    }
}
