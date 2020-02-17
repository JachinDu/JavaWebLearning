package sort_algo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/*
* 各种排序算法比较
* */
public class sortMethodCompare {
    //1.冒泡排序
    //复杂度：O(n2)
    public static void BubbleSort(int[] arr) {

        System.out.println("排序前："+ Arrays.toString(arr));
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            // 注意：每一轮外层循环后，都有一个元素不用再动了，所以内层循环的上界在不断缩小
            // 为arr.length - 1 - i
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

        }
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     *选择排序
     * 时间复杂度：O(n2)
     * */
    public static void selectSort(int[] arr) {
        System.out.println("排序前："+ Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            //循环找到未归位的数字中最小值标号
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //若最小值标号不为i，则需要交换
            if (minIndex != i) {
                swap(i, minIndex, arr);
            }
        }
        System.out.println("排序后："+ Arrays.toString(arr));
    }


    /*
     * 插入排序
     * 时间复杂度：O(n2)
     * */
    public static void insertSort(int[] arr) {
        System.out.println("排序前："+ Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {

            /*
            * 该内层循环体现"插入"排序，
            * 将新值与已排序好的前i项依次比较直到找到插入位置，
            * */
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                }
            }
        }
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    /*
     * 快速排序
     * 时间复杂度：O(N*logN)
     * */

//    public static void quickSort(int[] arr, int start, int end) {
//
//        // 必须要判断,处理key刚好在边界后
//        if(start < end){
//            // 获取分区点位置；且key左都小于arr[key],key右都大于arr[key]
//            int key = partition(arr, start, end);
//            /*
//             * key值已归位，不参与递归
//             * 继续给key左和key右分别进行快速排序
//             */
//            quickSort(arr,start,key-1);
//            quickSort(arr,key+1,end);
//        }
//    }

//    public static int partition(int[] arr, int start, int end) {
//        // 默认取头部元素为key，理论上key值任意选取
//        // 头部为key：遍历时要从后往前，尾部为key：遍历时从前往后
//        int keyV = arr[start];
//        int low = start; // 第一个坑位
//        int high = end;
//        while (low < high) {
//
//            // 从后往前找小于key的值
//            while (high > low && arr[high] >= keyV) {
//                high--;
//            }
//            // 去填low坑，并空出high坑
//            arr[low] = arr[high];
//
//            // 从low坑往后找到大于key的值
//            while (low < high && arr[low] <= keyV) {
//                low++;
//            }
//            // 去填high坑，并空出新low坑
//            arr[high] = arr[low];
//        }
//        // key值归位
//        arr[low] = keyV;
//        return low; // 返回key值位置
//    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int key = partition(nums, start, end);
            quickSort(nums, start, key - 1);
            quickSort(nums, key + 1, end);
        }

    }

    public static int partition(int[] nums, int start, int end) {
        int low = start;
        int high = end;
        int keyV = nums[start];
        while (low < high) {
            // 从后往前找小于keyV的
            while (high > low && nums[high] >= keyV) {
                high--;
            }
            nums[low] = nums[high];
            // 从前往后找大于keyV的
            while (low < high && nums[low] <= keyV) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = keyV;
        return low;
    }

    /*
     * 归并排序
     * 时间复杂度O(N*logN)
     * */
    //1.递归的分解称小序列
    //2.然后将排序好的小序列合并
    public static void mergeSort(int[] arr, int n){
        mergeSortExcu(arr,0,n-1);
    }

    public static void  mergeSortExcu(int[] arr, int begin, int end){
        if(begin < end){

            int mid = (begin + end)/2;
            mergeSortExcu(arr,begin,mid);
            mergeSortExcu(arr,mid+1,end);
            merge(arr,begin,mid,end);
        }
    }

    public static void merge(int[] arr,int begin, int mid, int end){
        int i = begin;
        int j = mid+1;
        int k = 0;

        // 创建一个临时数组用来存放合并后的结果
        int[] tmp = new int[end-begin+1];
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){ // 这个等号保证了稳定性
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        if(i > mid){
            while (j <= end) {
                tmp[k++] = arr[j++];
            }
        }
        if (j > end){
            while (i <= mid) {
                tmp[k++] = arr[i++];
            }
        }
        // 将临时数组中的元素(已排序)拷贝到原数组中
        for (int m = 0; m < tmp.length; m++){
            arr[begin+m] = tmp[m];
        }
    }



    /*
     * 堆排序（最大堆为例）
     * 时间复杂度O(N*logN)
     * */
    public static void heapSort(int[] array) {
        //1.先把无序数组构建成二叉堆
        for (int i = array.length / 2; i >= 0; i--) {
            downAjust(array,i,array.length);
        }
        System.out.println("排序前：" + Arrays.toString(array));
        // 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            // 每轮都将一个最大值放入了数组尾部，所以下沉调整时的下届在变化。
            downAjust(array,0,i);
        }

    }

    /*
     * 二叉堆的下沉调整
     * */
    public static void downAjust(int[] array, int parentIndex, int length) {
        //temp保存下沉节点值，用于最后的赋值，因为中间部分不用真赋值，反正要一步步下沉
        int temp = array[parentIndex];
        /*
        * 二叉堆是完全二叉树，顺序存储，不是链式存储，因此用的是数组存储；
        * 所以父节点为parent,则左儿子为2*parent+1,右儿子是2*parent+2
        * */
        int childIndex = 2*parentIndex + 1; // 先找左儿子
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                // 如果有右儿子且比左儿子还小，则找到右儿子
                childIndex++;
            }
            //parent大于（最小的儿子）所有儿子，则下沉结束
            if (temp >= array[childIndex]) {
                break;
            }
            // 否则下沉
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex + 1;
        }
        // 下沉到指定位置后，赋值
        array[parentIndex] = temp;

    }




    /*
     * 计数排序
     * */
//    public static int[] countSort(int[] array) {
//
//    }






    public static void main(String[] args) {
        int[] arr1 = {4, 6, 2, 1, 8, 9, 3, 2};
        int[] arr2 = {1,2,3,4,5,6};
        int[] arr3 = {0,11,2,4, 6, 2, 1, 8, 9, 3, 2};
//        BubbleSort(arr3);
//        selectSort(arr3);
//        insertSort(arr3);
//        mergeSort(arr3,arr3.length);
        System.out.println("排序前："+ Arrays.toString(arr3));
        quickSort(arr3,0,arr3.length-1);
//        heapSort(arr3);

//        mergeSort(arr3,arr3.length);
        System.out.println("排序后："+ Arrays.toString(arr3));


    }


}
