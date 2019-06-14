package sort_algo;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 各种排序算法比较
* */
public class sortMethodCompare {
    //1.冒泡排序
    //复杂度：O(n2)
    public static void BubbleSort(int[] arr) {

        System.out.println("排序前："+ Arrays.toString(arr));
        int temp = 0;
        boolean flag;  //排序完成时及时停止无意义当比较
        //每执行一次最外层，将有一个元素归位
        for (int i = 0; i < arr.length-1; i++) {
            flag = false;
            for (int j = arr.length-1; j > i; j--) {   //从后向前，依次比较相邻项
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
        System.out.println("排序后："+ Arrays.toString(arr));
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
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
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
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            /*
            * 该内层循环体现"插入"排序，
            * 将新值与以排序好的前i项依次比较直到找到插入位置，
            * 类似于冒泡，也可利用flag优化
            * */
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    /*
     * 快速排序
     * 时间复杂度：O(N*logN)
     * */
    public static void quickSort(int[] arr, int start, int end) {
        if (end < start) {
            return;
        }
        int i = start;
        int j = end;
        int key = arr[start];

        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < key) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        //直到i==j
        arr[i] = key;  //归位一个元素，即分界值
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }

    /*
     * 归并排序
     * 时间复杂度O(N*logN)
     * */
    //1.递归的分解称小序列
    //2.然后将排序好的小序列合并
    public static void mergeSort(int arr[], int first, int last, int[] temp) {
        if (first < last) {
            int middle = (first + last)/2;
            mergeSort(arr,first,middle,temp);
            mergeSort(arr,middle+1,last,temp);
            mergeArray(arr,first,middle,last,temp);
        }
    }

    public static void mergeArray(int[] a, int first, int middle, int end, int[] temp) {
        int k = 0;
        int i = first;
        int j = middle+1;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //某一个子数组已经取完后直接将另一个未取完的子数组中的数依次放入temp
        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        //将合并后的子数组填充到主数组去
        for (int n = 0; n < k; n++) {
            a[first + n] = temp[n];
        }
    }

    /*
     * 堆排序
     * 时间复杂度O(N*logN)
     * */
    public static void heapSort(int[] array) {
        //1.先把无序数组构建成二叉堆
        for (int i = array.length / 2; i >= 0; i--) {
            downAjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));
        // 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
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
        int childIndex = 2*parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            //parent大于所有儿子，则下沉结束
            if (temp >= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex + 1;
        }
        array[parentIndex] = temp;

    }

    /*
     * 计数排序
     * */
    public static int[] countSort(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        int[] countArray = new int[maxValue - minValue + 1];

        /*
        * 将要排序数组中元素的值计数于计数数组相应的下标中(a[i]-minValue)
        * minValue为偏移值
        * */
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - minValue]++;
        }
        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i+minValue;  //！！！！切记记得把偏移值minValue加上
            }
        }
        return sortedArray;
    }






    public static void main(String[] args) {
        int[] arr1 = {4, 6, 2, 1, 8, 9, 3, 2};
        int[] arr2 = {1,2,3,4,5,6};
        int[] arr3 = {0,11,2,4, 6, 2, 1, 8, 9, 3, 2};
        int[] temp = new int[arr3.length];
//        BubbleSort(arr2);
//        selectSort(arr1);
//        insertSort(arr1);
//        quickSort(arr3,0,arr3.length-1);
//        mergeSort(arr3,0,arr3.length-1,temp);
//        heapSort(arr1);

        System.out.println("排序后："+ Arrays.toString(countSort(arr3)));


    }


}
