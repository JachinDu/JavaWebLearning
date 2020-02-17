import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/04 10:44
 */

class TrapNode{
     int height;
     int row;
     int col;

    public TrapNode(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class TrapRain2 {

    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        if (rows == 0) {
            return 0;
        }
        int cols = heightMap[0].length;
        int[][] visited = new int[rows][cols];
        Queue<TrapNode> priorityQueue = new PriorityQueue<>(new Comparator<TrapNode>() {
            @Override
            public int compare(TrapNode o1, TrapNode o2) {
                return o1.height - o2.height;
            }
        });

        for (int i = 0; i < rows; i++) {
            priorityQueue.add(new TrapNode(heightMap[i][0],i,0));
            priorityQueue.add(new TrapNode(heightMap[i][cols - 1], i, cols - 1));
            visited[i][0] = 1;
            visited[i][cols - 1] = 1;
        }
        for (int j = 1; j < cols - 1; j++) {
            priorityQueue.add(new TrapNode(heightMap[0][j], 0, j));
            priorityQueue.add(new TrapNode(heightMap[rows - 1][j], rows - 1, j));
            visited[0][j] = 1;
            visited[rows - 1][j] = 1;
        }

        int currMinBound = Integer.MIN_VALUE;
        int total = 0;
        while (priorityQueue.size() != 0) {
            TrapNode node = priorityQueue.poll();
            currMinBound = Math.max(node.height, currMinBound);
            if (node.row > 0 && visited[node.row - 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row - 1][node.col], node.row - 1, node.col));
                visited[node.row - 1][node.col] = 1;
                if (heightMap[node.row - 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row - 1][node.col]);
                }
            }
            if (node.row < rows - 1 && visited[node.row + 1][node.col] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row + 1][node.col], node.row + 1, node.col));
                visited[node.row + 1][node.col] = 1;
                if (heightMap[node.row + 1][node.col] < currMinBound) {
                    total += (currMinBound - heightMap[node.row + 1][node.col]);
                }
            }

            if (node.col > 0 && visited[node.row][node.col - 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col - 1], node.row, node.col - 1));
                visited[node.row][node.col - 1] = 1;
                if (heightMap[node.row][node.col - 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col - 1]);
                }
            }
            if (node.col < cols - 1 && visited[node.row][node.col + 1] == 0) {
                priorityQueue.add(new TrapNode(heightMap[node.row][node.col + 1], node.row, node.col + 1));
                visited[node.row][node.col + 1] = 1;
                if (heightMap[node.row][node.col + 1] < currMinBound) {
                    total += (currMinBound - heightMap[node.row][node.col + 1]);
                }
            }

        }
        return total;
    }
}
