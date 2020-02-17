import java.util.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/05 14:34
 */

public class PacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new ArrayList<>();
        }
        int cols = matrix[0].length;
        int[][] pacific = new int[rows][cols];
        int[][] atlantic = new int[rows][cols];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            pacific[i][0] = 1;
            queue1.add(new int[]{i, 0});

            atlantic[i][cols - 1] = 1;
            queue2.add(new int[]{i, cols - 1});
        }
        for (int i = 0; i < cols; i++) {
            pacific[0][i] = 1;
            queue1.add(new int[]{0, i});

            atlantic[rows - 1][i] = 1;
            queue2.add(new int[]{rows - 1, i});
        }

         //太平洋, 从左上bfs
        while (queue1.size() != 0) {
            int[] land = queue1.poll();
            int x = land[0];
            int y = land[1];
            if (x > 0 && pacific[x - 1][y] != 1) {
                if (matrix[x - 1][y] >= matrix[x][y]) {
                    pacific[x-1][y] = 1;
                    queue1.add(new int[]{x - 1, y});
                }
            }
            if (x < rows - 1 && pacific[x + 1][y] != 1) {
                if (matrix[x + 1][y] >= matrix[x][y]) {
                    pacific[x+1][y] = 1;
                    queue1.add(new int[]{x + 1, y});
                }
            }
            if (y > 0 && pacific[x][y - 1] != 1) {
                if (matrix[x][y - 1] >= matrix[x][y]) {
                    pacific[x][y - 1] = 1;
                    queue1.add(new int[]{x, y - 1});
                }
            }
            if (y < cols - 1 && pacific[x][y + 1] != 1) {
                if (matrix[x][y + 1] >= matrix[x][y]) {
                    pacific[x][y + 1] = 1;
                    queue1.add(new int[]{x, y + 1});
                }
            }
        }

        // 大西洋
        while (queue2.size() != 0) {
            int[] land = queue2.poll();
            int x = land[0];
            int y = land[1];
            if (x > 0 && atlantic[x - 1][y] != 1) {
                if (matrix[x - 1][y] >= matrix[x][y]) {
                    atlantic[x-1][y] = 1;
                    queue2.add(new int[]{x - 1, y});
                }
            }
            if (x < rows - 1 && atlantic[x + 1][y] != 1) {
                if (matrix[x + 1][y] >= matrix[x][y]) {
                    atlantic[x+1][y] = 1;
                    queue2.add(new int[]{x + 1, y});
                }
            }
            if (y > 0 && atlantic[x][y - 1] != 1) {
                if (matrix[x][y - 1] >= matrix[x][y]) {
                    atlantic[x][y - 1] = 1;
                    queue2.add(new int[]{x, y - 1});
                }
            }
            if (y < cols - 1 && atlantic[x][y + 1] != 1) {
                if (matrix[x][y + 1] >= matrix[x][y]) {
                    atlantic[x][y + 1] = 1;
                    queue2.add(new int[]{x, y + 1});
                }
            }
        }

        // dfs
        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific, matrix, matrix[0][i]);
            dfs(rows - 1, i, atlantic, matrix, matrix[rows - 1][i]);
        }
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, matrix, matrix[i][0]);
            dfs(i, cols - 1, atlantic, matrix, matrix[i][cols - 1]);
        }



        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;

    }


    public void dfs(int x, int y, int[][] ocean, int[][] matrix, int pre) {
        if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1 || ocean[x][y] == 1 || matrix[x][y] < pre) {
            return;
        }
        ocean[x][y] = 1;
        dfs(x + 1, y, ocean, matrix, matrix[x][y]);
        dfs(x - 1, y, ocean, matrix, matrix[x][y]);
        dfs(x, y + 1, ocean, matrix, matrix[x][y]);
        dfs(x, y - 1, ocean, matrix, matrix[x][y]);
    }
}
