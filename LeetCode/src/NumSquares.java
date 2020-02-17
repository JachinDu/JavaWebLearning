import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/28 14:26
 */

public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        boolean flag = false;
        for (int i = 2; i < n+1; i++) {
            flag = false;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                if (j * j == i + 1) {
                    dp[i] = 1;
                    flag = true;
                    break;
                } else {
                    min = Math.min(min,dp[i-j*j] + 1);
                }
            }
            dp[i] = flag ? dp[i] : min;
        }
        return dp[n];
    }
}
