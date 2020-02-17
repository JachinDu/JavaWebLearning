import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/14 10:00
 */

public class WorkStealingPool1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

    }


}
