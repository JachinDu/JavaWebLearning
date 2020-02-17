import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/02 13:01
 */

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        if (len == 0 || len == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[len][2];
        int left = intervals[0][0];
        int right = intervals[0][1];

        int index = 0;
        int resLen = len;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] <= right) {
                if (intervals[i][1] > right) {
                    right = intervals[i][1];
                }
                if (i == len - 1) {
                    res[index][0] = left;
                    res[index][1] = right;
                }
                resLen--;
            } else {
                res[index][0] = left;
                res[index][1] = right;
                index++;
                left = intervals[i][0];
                right = intervals[i][1];
                if (i == len - 1) {
                    res[index][0] = left;
                    res[index][1] = right;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, resLen);  // 左区间闭，右区间开
    }
}
