import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/14 10:52
 */

public class MergeSortByForkJoin {
    static int[] nums = new int[100000];
    static int[] nums2 = new int[100000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            int rr = r.nextInt(10000);
            nums[i] = rr;
            nums2[i] = rr;
        }
//        System.out.println("nums: " + Arrays.toString(nums));
//        System.out.println("nums2: " + Arrays.toString(nums2));

    }

    static void mergeSort(int start, int end, int[] arr) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start,mid,arr);
            mergeSort(mid + 1, end, arr);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        if (i > mid) {
            while (j <= end) {
                temp[k++] = arr[j++];
            }
        }
        if (j > end) {
            while (i <= mid) {
                temp[k++] = arr[i++];
            }
        }
        for (int m = 0; m < temp.length; m++) {
            arr[start + m] = temp[m];
        }
    }

    static class ForkJoinMergeSort extends RecursiveTask<int[]> {

        int start,end;

        public ForkJoinMergeSort(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected int[] compute() {
            if (end - start < MAX_NUM) {
                mergeSort(start, end, nums2);
            } else {
                int mid = start + (end - start) / 2;
                ForkJoinMergeSort subSort1 = new ForkJoinMergeSort(start, mid);
                ForkJoinMergeSort subSort2 = new ForkJoinMergeSort(mid+1, end);
                subSort1.fork();
                subSort2.fork();
                subSort1.join();
                subSort2.join();
                merge(nums2,start,mid,end);
            }
            return nums2;
        }
    }

    public static void main(String[] args) {
        long startT = System.currentTimeMillis();
        mergeSort(0,nums.length-1,nums);
        long endT = System.currentTimeMillis();
        System.out.println("one thread time: " + (endT - startT));
        System.out.println("sort result: "+ Arrays.toString(nums));

        ForkJoinPool fjp = new ForkJoinPool();

        ForkJoinMergeSort fjm = new ForkJoinMergeSort(0, nums2.length-1);
        startT = System.currentTimeMillis();
        fjp.execute(fjm);
        int[] x = fjm.join();
        endT = System.currentTimeMillis();
        System.out.println(" multi thread time: " + (endT - startT));
        System.out.println("sort result: " + Arrays.toString(nums2));

    }

}
