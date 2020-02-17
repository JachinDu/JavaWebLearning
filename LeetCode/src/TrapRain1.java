/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/03 20:11
 */

public class TrapRain1 {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int maxH = 0;
        int maxHIndex = 0;
        int i = 0;
        // 找到最大值中的任意一个就行
        while (i < len) {
            if (height[i] > maxH) {
                maxH = height[i];
                maxHIndex = i;
            }
            i++;
        }

        int total = 0;
        // 从左遍历
        int maxLeft = height[0];
        for (int l = 0; l < maxHIndex; l++) {
            maxLeft = Math.max(maxLeft, height[l]);
            total = total + Math.min(maxLeft, maxH) - height[l];
        }

        // 从右
        int maxRight = height[len - 1];
        for (int r = len - 1; r > maxHIndex; r--) {
            maxRight = Math.max(maxRight, height[r]);
            total = total + Math.min(maxRight, maxH) - height[r];
        }
        return total;
    }
}
