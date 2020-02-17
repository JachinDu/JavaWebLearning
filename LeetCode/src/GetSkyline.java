import java.util.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/31 21:45
 */

class Point{
    public int x;
    public int height;
    public int flag;

    public Point(int x, int height, int flag) {
        this.x = x;
        this.height = height;
        this.flag = flag;  // 0: 左端点， 1：右端点
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
                height == point.height &&
                flag == point.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, height, flag);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Point() {
    }
}

public class GetSkyline {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        TreeSet<Point> set = new TreeSet<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    if (o1.flag != o2.flag || o1.flag == 0 && o2.flag == 0) {
                        return o2.height - o1.height;
                    } else {
                        return o1.height - o2.height;
                    }
                }
            }
        });


        for (int i = 0; i < buildings.length; i++) {
            Point p1 = new Point(buildings[i][0], buildings[i][2], 0);
            Point p2 = new Point(buildings[i][1], buildings[i][2], 1);
            if (!set.contains(p1)) {
                set.add(p1);
            }else {
                set.remove(p1);
            }
            if (!set.contains(p2)) {
                set.add(p2);
            } else {
                set.remove(p2);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        while (set.size() != 0) {
            Point node = set.pollFirst();

            if (node.flag == 0) {
                if (maxHeap.peek() == null || maxHeap.peek() < node.height) {
                    maxHeap.add(node.height);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node.x);
                    temp.add(node.height);
                    res.add(temp);
                } else {
                    maxHeap.add(node.height);
                }
            } else {
                if (maxHeap.remove(node.height)) {
                    List<Integer> temp = new ArrayList<>();
                    if (maxHeap.size() == 0) {
                        temp.add(node.x);
                        temp.add(0);
                        res.add(temp);
                    } else {
                        if (maxHeap.peek() < node.height) {
                            temp.add(node.x);
                            temp.add(maxHeap.peek());
                            res.add(temp);
                        }
                    }

                }
            }

        }
        return res;
    }
}