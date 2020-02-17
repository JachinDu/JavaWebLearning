import java.util.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/07 19:05
 */

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[][] graph = new double[26][26];  // 给每一个字母对应一个标号，来建立一张图
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                graph[i][j] = Double.MAX_VALUE;
            }
        }

        HashMap<String,Integer> map = new HashMap<>();  // 其中字母与标号的映射用一个map实现
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {

            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);

            if (!map.containsKey(A)) {
                map.put(A, index++);
            }
            if (!map.containsKey(B)) {
                map.put(B, index++);
            }
            graph[map.get(A)][map.get(B)] = values[i];
            if (values[i] != 0) {
                graph[map.get(B)][map.get(A)] = 1 / values[i];
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);
            if (map.containsKey(A) && map.containsKey(B)) {

                int src = map.get(A);
                int dest = map.get(B);
                double weight = 1.0;
                HashSet<Integer> visited = new HashSet<>();
                res[i] = dfs(src,dest,graph,weight,visited);

            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    public double dfs(int src, int dest, double[][] graph, double weight, HashSet<Integer> lastVisited) {
        // visited 避免环路
        // 因为java传递set时为引用，所以要在内部重新处理
        HashSet<Integer> visited = new HashSet<>(lastVisited);
        visited.add(src);

        if (src == dest) {
            return weight;
        }
        for (int i = 0; i < 26; i++) {
            double temp = Double.MIN_VALUE;
            if (src != i && graph[src][i] != Double.MAX_VALUE && (!visited.contains(i))) {

                visited.add(i);
                temp = dfs(i, dest, graph, weight * graph[src][i], visited);
                if (temp != Double.MIN_VALUE && temp != (-1.0)) {
                    return temp;
                }
            }
        }
        return -1.0;
    }
}
