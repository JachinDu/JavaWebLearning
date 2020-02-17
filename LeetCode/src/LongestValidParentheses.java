import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/12/04 12:56
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        // 法1：暴力法，计算所有偶数长度是否为有效字符串
        // 法2：dp, 时间复杂度：O(n)，空间复杂度O(n)
//        int[] dp = new int[s.length()]; // dp[i]代表以i结尾的最长有效括号字符串
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (i == 0) {
//                    dp[i] = 0;
//                } else if (s.charAt(i-1) == '(') {
//                    if (i > 1) {
//                        dp[i] = dp[i - 2] + 2;
//                    } else {
//                        dp[i] = 2;
//                    }
//                } else if (s.charAt(i - 1) == ')') {
//                    if (i - dp[i - 1] < 1) {
//                        dp[i] = 0;
//                    }else if (s.charAt(i - dp[i - 1] - 1) == '(') {
//                        if (i - dp[i - 1] < 2) {
//                            dp[i] = dp[i - 1] + 2;
//                        } else {
//                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
//                        }
//                    }
//                }
//            }
//            maxLen = Math.max(maxLen, dp[i]);
//        }

        // 法3：栈,将下标入栈，做差得长度（巧妙）
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 这里-1用来错位，精髓
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
