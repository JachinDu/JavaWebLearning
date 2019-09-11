import java.util.Arrays;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/30 14:12
 */

public class HelloWorld {
    public static void main(String []args) {

        int[] x = {0,3,3,3,3,2,1};

        int[] array = Arrays.copyOfRange(x,2,5);
        System.out.println("Hello World!");
    }
}
