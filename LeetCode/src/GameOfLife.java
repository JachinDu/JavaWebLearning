import java.util.Arrays;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/25 14:49
 */

public class GameOfLife {

    // 0 --> 1 : 则将其设为2
    // 1 --> 0 : 则将其设为3

    private int aliveCellNum;

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                aliveCellNum = 0;
                if (board[i][j] == 1) {
                    StaticsAliveCells(i, j, board);
                    if (aliveCellNum < 2 || aliveCellNum > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    StaticsAliveCells(i, j, board);
                    if (aliveCellNum == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void StaticsAliveCells(int i, int j, int[][] board) {
        if (i - 1 >= 0) {
            StaticsByRow(i - 1, j, board, true);
        }
        StaticsByRow(i, j, board, false);
        if (i + 1 < board.length) {
            StaticsByRow(i + 1, j, board, true);
        }
    }

    public void StaticsByRow(int row, int col, int[][] board, boolean flag) {
        if (flag && (board[row][col] == 1 || board[row][col] == 3)) {
            aliveCellNum++;
        }
        if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 3)) {
            aliveCellNum++;
        }
        if (col + 1 < board[0].length && (board[row][col + 1] == 1 || board[row][col + 1] == 3)) {
            aliveCellNum++;
        }
    }
}
