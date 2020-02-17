import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/13 14:59
 */

class Main {
    public static void main (String[] args) throws java.lang.Exception {
//        Solution s = new Solution();
//        s.isNumeric("123.45e+6".toCharArray());
////        System.out.println(s.rightSideView());
//        Map<Short, String> map = new HashMap<>();
//        for(short i = 0; i < 100; i++) {
//            map.put(i, String.valueOf(i));
//            map.remove(i-1);
//        }
//        System.out.println(map.size());
        MyGenerec<Integer> m1 = new MyGenerec<>(2);
        dowork(m1);
    }
    public static void dowork(MyGenerec<?> m){
        System.out.println(m.data);
    }
}
class  MyGenerec<T>{
    T data;

    public MyGenerec(T data) {
        this.data = data;
    }
}


