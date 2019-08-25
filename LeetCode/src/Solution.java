//
//
//public class Solution {
//    private int[] flagArr;
//    public boolean canJump(int[] nums) {
//        flagArr = new int[nums.length];
//        return find(nums, nums.length - 1);
//    }
//
//    public boolean find(int[] nums, int destIndex) {
//        if (destIndex <= 0) {
//            return true;
//        } else {
//            for (int i = destIndex - 1; i >= 0; i--) {
//                if (nums[i] >= destIndex - i) {
//                    if (flagArr[i] == 1) {
//                        continue;
//                    }
//                    boolean flag = find(nums, i);
//                    flagArr[i] = 1;
//                    if (flag) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Solution sl = new Solution();
//        sl.ff();
//    }
//
//    public void ff() {
//        flagArr = new int[10];
//        System.out.println(flagArr[3]);
//    }
//
//
//
//}



/*
    11   13
    12   23
    13   33

    21   12
    22   22
    23   32

    31   11
    32   21
    33   31
 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}

