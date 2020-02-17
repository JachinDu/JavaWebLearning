import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/25 19:17
 */

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        int end = 0;
        int head = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while (end < len) {
            while (end < len-1 && people[end + 1][0] == people[head][0]) {
                end++;
            }

            for (int i = head; i <= end; i++) {
                list.add(people[i][1], people[i]);
            }
            head = end + 1;
            end = head;
        }

        return list.toArray(new int[len][2]);
    }
}
