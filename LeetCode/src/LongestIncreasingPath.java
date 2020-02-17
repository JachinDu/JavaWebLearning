import java.util.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/12/04 14:47
 */

public class LongestIncreasingPath {

//    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 利用这个递归更快
//    // 法1：动态规划
//    // 缺点：必须有个排序，保证小的已经计算过，导致时间长
//
//    public int longestIncreasingPath(int[][] matrix) {
//        int rows = matrix.length;
//        if (rows == 0) {
//            return 0;
//        }
//        int cols = matrix[0].length;
////        List<MatrixNode> list = new ArrayList<>();
//        Queue<MatrixNode> prioriQueue = new PriorityQueue<>(new Comparator<MatrixNode>() {
//            @Override
//            public int compare(MatrixNode o1, MatrixNode o2) {
//                return o1.value - o2.value;
//            }
//        });
//        int[][] dp = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
////                list.add(new MatrixNode(matrix[i][j], i, j));
//                prioriQueue.add(new MatrixNode(matrix[i][j], i, j));
//                dp[i][j] = 1;
//            }
//        }
////        list.sort(new Comparator<MatrixNode>() {
////            @Override
////            public int compare(MatrixNode o1, MatrixNode o2) {
////                return o1.value - o2.value;
////            }
////        });
//
//
//        int x = 0;
//        int y = 0;
//        int value = 0;
//        int maxLen = 1;
//        prioriQueue.poll();
//        while (!prioriQueue.isEmpty()) {
////            MatrixNode currNode = list.get(i);
//            MatrixNode currNode = prioriQueue.poll();
//            x = currNode.row;
//            y = currNode.col;
//            value = currNode.value;
//            for (int[] d : dirs) {
//                int i = x + d[0], j = y + d[1];
//                if (0 <= i && i < rows && 0 <= j && j < cols && matrix[i][j] < matrix[x][y]) {
//                    dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
//                }
//             }
////            if (x >= 1 && matrix[x - 1][y] < value) {
////                dp[x][y] = Math.max(dp[x][y], dp[x - 1][y] + 1);
////            }
////            if (x < rows - 1 && matrix[x + 1][y] < value) {
////                dp[x][y] = Math.max(dp[x][y],dp[x + 1][y] + 1);
////            }
////            if (y >= 1 && matrix[x][y - 1] < value) {
////                dp[x][y] = Math.max(dp[x][y], dp[x][y - 1] + 1);
////            }
////            if (y < cols - 1 && matrix[x][y + 1] < value) {
////                dp[x][y] = Math.max(dp[x][y],dp[x][y + 1] + 1);
////            }
//            maxLen = Math.max(maxLen, dp[x][y]);
//        }
//        return maxLen;
//    }

    // 法2：记忆化DFS
    private int rows;
    private int cols;
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 利用这个递归更快
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        cols = matrix[0].length;

        int maxLen = 0;
        int[][] cache = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, cache));
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int x, int y, int[][] cache) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }
//        if (x >= 1 && matrix[x - 1][y] > matrix[x][y]) {
//            cache[x][y] = Math.max(cache[x][y], dfs(matrix, x - 1, y, cache));
//        }
//        if (x < rows - 1 && matrix[x + 1][y] > matrix[x][y]) {
//            cache[x][y] = Math.max(cache[x][y], dfs(matrix, x + 1, y, cache));
//        }
//        if (y >= 1 && matrix[x][y - 1] > matrix[x][y]) {
//            cache[x][y] = Math.max(cache[x][y], dfs(matrix, x, y - 1, cache));
//        }
//        if (y < cols - 1 && matrix[x][y + 1] > matrix[x][y]) {
//            cache[x][y] = Math.max(cache[x][y], dfs(matrix, x, y + 1, cache));
//        }

        // 整合成这样更快！！！
        for (int[] d : dirs) {
            int i = x + d[0], j = y + d[1];
            if (0 <= i && i < rows && 0 <= j && j < cols && matrix[i][j] > matrix[x][y]) {
                cache[x][y] = Math.max(cache[x][y], dfs(matrix, i, j, cache));
            }
        }

        return ++cache[x][y];
    }
}

class MatrixNode{
    int value;
    int row;
    int col;

    public MatrixNode(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
