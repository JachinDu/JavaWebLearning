import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/12 19:34
 */

public class MedianFinder {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.add(num);
        } else {
            if (minHeap.peek() <= num) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.size() == 0) {
                return 0;
            } else {
                return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            }
        } else {
            if (minHeap.size() > maxHeap.size()) {
                return (double) minHeap.peek();
            } else {
                return (double) maxHeap.peek();
            }
        }

    }
}
