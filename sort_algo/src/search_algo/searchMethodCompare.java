package search_algo;

/*
 * 各类查找算法
 * */

import sort_algo.sortMethodCompare;

import java.util.Arrays;

public class searchMethodCompare {
    /*
     * 二分查找
     * 期望时间复杂度为O(log2^n)
     * ！！！！！前提是数组必须先有序
     * */
    public static int binarySearch(int[] arr, int value, int low, int high) {
        int mid = low+(high-low)/2;
        if (mid < 0 || mid > high) {
            return -1;
        }
        if (arr[mid] == value) {
            return mid;
        }
        if (arr[mid] > value) {
            return binarySearch(arr,value,low,mid-1);
        }
        if (arr[mid] < value) {
            return binarySearch(arr, value, mid + 1, high);
        }
        return -1;
    }

    /*
     * 插值查找
     * 基于二分查找的改进
     * 时间复杂度均为O(log2(log2^n))
     * */
    public static int insertSearch(int[] arr, int value, int low, int high) {
        int mid = low + ((value-arr[low])/(arr[high]-arr[low]))*(high-low);
        if (mid < 0 || mid > high) {
            return -1;
        }
        if (arr[mid] == value) {
            return mid;
        }
        if (arr[mid] > value) {
            return binarySearch(arr,value,low,mid-1);
        }
        if (arr[mid] < value) {
            return binarySearch(arr, value, mid + 1, high);
        }
        return -1;
    }

    /*
     * 斐波那契查找
     * 根据一个斐波那契数F将数组分为两部分，前部分的长度是合成F中的那个较大值，后部分是另一个值
     * 基于插值查找改造：二分，插值，斐波那契的区别就是mid点的选取
     * 时间复杂度为O(log2^n)
     * */

    /*
     * 斐波那契数列生成器
     * */
    public static void produceFib(int[] fibArr, int size) {
        fibArr[0] = 1;
        fibArr[1] = 1;
        for (int i = 2; i < size; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
    }

    /*
     * 斐波那契查找算法
     * */
    public static int fibSearch(int[] arr,int value,int length, int fibSize) {
        int[] fibArr = new int[fibSize];
        produceFib(fibArr,fibSize);
        System.out.println("生成的斐波那契数个数："+fibSize);
        System.out.println("生成的斐波那契数列：" + Arrays.toString(fibArr));

        int low = 0;
        int high = length-1;
        int k = 0;

        //找到最接近查找数组长度的斐波那契的值
        while (high > fibArr[k] - 1) {
            k++;
        }
        System.out.println("找到的最接近数组长度的斐波那契值为："+ fibArr[k]);

        //给原数组扩容
        int[] searchArr = new int[fibArr[k]];
        System.arraycopy(arr,0,searchArr,0,arr.length);

        //补齐查找数组
        for (int i = length; i < fibArr[k]; i++) {
            //用原数组最后一个元素在末尾补全新数组
            searchArr[i] = arr[high];
        }
        System.out.println("补全后的新数组为："+ Arrays.toString(searchArr));

        while (low <= high) {
            int mid = low + fibArr[k-1] - 1;   //这里最后的减一是和数组下标从0开始有关的，[k-1]是取了合成fibArr[k]中的值大的那个

            if (searchArr[mid] == value) {
                if (mid <= length - 1) {
                    return mid;
                } else {
                    //说明查到的都是补全值
                    return length-1;
                }
            }

            if (searchArr[mid] < value) {
                low = mid + 1;
                k -= 2;    //因为要继续分割右端，右端本来就是长度短的那端，注意这里减2。
            }
            if (searchArr[mid] > value) {
                high = mid - 1;
                k -= 1;   //区别上面，这里减1。
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 33, 22};
        int[] sortedArr = sortMethodCompare.countSort(arr);
        System.out.println(Arrays.toString(sortedArr));
//        System.out.println(binarySearch(sortedArr,33,0,arr.length-1));
//        System.out.println(insertSearch(sortedArr,1,0,arr.length-1));
        System.out.println(fibSearch(sortedArr,33,sortedArr.length,10));
    }
}
