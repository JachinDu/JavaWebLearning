import java.util.HashSet;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/26 21:18
 */

public class IsRectangleCover {
    private HashSet<String> set;
    private String[] endLeftUpLoc;
    private String[] endRightDownLoc;
    public boolean isRectangleCover(int[][] rectangles) {
        int len = rectangles.length;
        set = new HashSet<>();
        int area = 0;
        for (int i = 0; i < len; i++) {
            String leftUp = rectangles[i][0] + " " + rectangles[i][1];
            String rightDown = rectangles[i][2] + " " + rectangles[i][3];
            String leftDown = rectangles[i][2] + " " + rectangles[i][1];
            String rightUp = rectangles[i][0] + " " + rectangles[i][3];
            area = area + (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
            save(leftDown);
            save(leftUp);
            save(rightDown);
            save(rightUp);
        }
        if (set.size() != 4) {
            return false;
        } else {
            boolean flag = true;
            for (String node : set) {
                if (flag) {
                    endLeftUpLoc = node.split(" ");
                    flag = false;
                } else {
                    String[] loc = node.split(" ");
                    if (!loc[0].equals(endLeftUpLoc[0])  && !loc[1].equals(endLeftUpLoc[1])) {
                        endRightDownLoc = node.split(" ");
                    }
                }
            }
            int endArea = (Math.abs(Integer.parseInt(endLeftUpLoc[0]) - Integer.parseInt(endRightDownLoc[0])) * Math.abs(Integer.parseInt(endLeftUpLoc[1]) - Integer.parseInt(endRightDownLoc[1])));
            return endArea == area;
        }
    }

    public void save(String node) {
        if (!set.contains(node)) {
            set.add(node);
        }else {
            set.remove(node);
        }
    }
}
