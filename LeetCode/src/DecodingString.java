import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/21 20:45
 */

public class DecodingString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr != ']') {
                stack.push(String.valueOf(curr));
            } else {
                StringBuilder sb = new StringBuilder();
                while(!"[".equals(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder Num = new StringBuilder();
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    Num.append(stack.pop());
                }

                int repeatCount = Integer.parseInt(Num.reverse().toString());
                String repeateString =  sb.toString();
                for (int j = 0; j < repeatCount; j++) {
//                    for (int k = 0; k < repeateString.length(); k++) {
//                        stack.push(String.valueOf(repeateString.charAt(k)));
//                    }
                    stack.push(repeateString);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        String resu = res.reverse().toString();
        System.out.println(resu);
        return resu;
    }

}
