import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/21 10:05
 */

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start = nums[0];
        int end = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
                if (i == nums.length - 1) {
                    res.add(start + "->" + end);
                }
            } else {
                if (start == end) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + end);
                }
                if (i == nums.length - 1) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    start = nums[i];
                    end = nums[i];
                }

            }
        }
        return res;
    }
}
