import java.util.Arrays;
import java.util.Scanner;

class Main2 {

//    public static int binarySearchLowerBound(int[] A, int target, int n){
//        int low = 0, high = n, mid;
//        while(low <= high){
//            mid = low + (high - low) / 2;
//            if(target > A[mid]){
//                low = mid + 1;
//            }else{
//                high = mid - 1;
//            }
//
//        }
//        return low > n ? -1 : low;
//    }

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
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] Resultx = new int[m];
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
//            Arrays.sort(a);
            a = countSort(a);
            int k = 0;
            for (int j = 0; j < m; j++) {
                int index = a.length;
                    k = scanner.nextInt();
                    int arrLenth = a.length;
                    int Result = 0;

                int[] indexArr = new int[a.length];
                int start = 0;
                int end = a.length-1;
                while (true) {

                    if (start >= end) {
                        break;
                    }

                    if (a[start] + a[end] >= k) {
                        end--;
                    }
                    if (a[start] + a[end] < k || end == 0){
                        indexArr[start] = end+1;
                        start++;
                    }

                }

                for (int i = 0; i < start; i++) {
                     int llength = arrLenth - indexArr[i];
                    Result += (llength)*(llength-1)/2;
                    Result += llength*(indexArr[i]-i);
                    arrLenth = indexArr[i];
                }

                Resultx[j] = Result;
            }
            for (int i = 0; i < Resultx.length; i++) {
                System.out.println(Resultx[i]);
            }
//            System.out.println(binarySearchLowerBound(a,4,a.length-1));

        }



    }
}
