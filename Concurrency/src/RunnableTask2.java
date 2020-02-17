/**
 * @description:
 * @Author: JachinDo
 * @Date: 2020/01/06 13:20
 */

public class RunnableTask2 implements Runnable {
    private volatile int[] arr = new int[20];
    @Override
    public void run() {
        //Thread B
        while (arr[19] != 2) {
            System.out.println("looping.....");
        }
        System.out.println("Jump out of the loop!");
    }
}
