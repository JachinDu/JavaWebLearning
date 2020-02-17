
/*
* 各类查找算法
* */
public class SearchAlgo {
    /*
     * 二分查找
     * */
    public static int binarySearch(int[] arr, int value, int low, int high) {
        int mid = low+(high-low)/2;
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






    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 33, 22};
        System.out.println(binarySearch(arr,23,0,arr.length-1));
    }
}
