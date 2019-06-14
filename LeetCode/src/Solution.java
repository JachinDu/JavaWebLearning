

public class Solution {
    private int[] flagArr;
    public boolean canJump(int[] nums) {
        flagArr = new int[nums.length];
        return find(nums, nums.length - 1);
    }

    public boolean find(int[] nums, int destIndex) {
        if (destIndex <= 0) {
            return true;
        } else {
            for (int i = destIndex - 1; i >= 0; i--) {
                if (nums[i] >= destIndex - i) {
                    if (flagArr[i] == 1) {
                        continue;
                    }
                    boolean flag = find(nums, i);
                    flagArr[i] = 1;
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.ff();
    }

    public void ff() {
        flagArr = new int[10];
        System.out.println(flagArr[3]);
    }



}