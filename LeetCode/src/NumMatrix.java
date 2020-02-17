/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/20 20:04
 */

public class NumMatrix {

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        dp = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0];
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                dp[i][j] = dp[i][j-1] + matrix[i][j];
            }
        }
    }
    private int[][] matrix;
    private int[][] dp;

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix.length == 0) {
            return 0;
        }
        if(row1 == row2 && col1 == col2) {
            return matrix[row1][col1];
        }
        int res = 0;
        for(int i = row1; i <= row2; i++){
            if(col1 - 1 < 0) {
                col1 = 1;
            }
            res += dp[i][col2] - dp[i][col1-1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
