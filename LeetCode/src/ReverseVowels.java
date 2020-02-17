import java.util.Arrays;
import java.util.HashSet;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/30 20:37
 */

public class ReverseVowels {
    public String reverseVowels(String s) {
//        int head = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        for (int i = 0; i < end; i++) {
            if (set.contains(arr[i])) {
                while (end > i) {
                    if (set.contains(arr[end])) {
                        char temp = arr[i];
                        arr[i] = arr[end];
                        arr[end] = temp;
                        end--;
                        break;
                    }
                    end--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
