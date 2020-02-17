import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/23 15:41
 */

public class NumIslandsSolution {
    private int[] id;
    private int[] sz;
    private int groupNum;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        id = new int[rows * cols + 1];
        int idLen = id.length;
        for (int i = 0; i < idLen; i++) {
            id[i] = i;
        }
        sz = new int[idLen];
        for (int i = 0; i < idLen; i++) {
            sz[i] = 1;
        }
        groupNum = idLen;

        for (int i = 0; i < idLen - 1; i++) {
            int row = i / cols;
            int col = i % cols;
            if (grid[row][col] == '1') {
                if (row + 1 < rows && grid[row + 1][col] == '1') {
                    union(i, i + cols);
                }
                if (col + 1 < cols && grid[row][col + 1] == '1') {
                    union(i, i + 1);
                }
            } else {
                union(i, idLen - 1);
            }
        }
        return groupNum - 1;
    }

    private int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        // 将小树作为大树的子树
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        groupNum--;
    }
}
