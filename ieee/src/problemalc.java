import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main1 {

    public static int calNode(int nx,int ny,int[][] arr,int a) {
        if (nx == 1 && ny==1) {
            return arr[0][0];
        }
        if (nx == 2 && ny==2) {
            return a * arr[0][1] + a * arr[1][0];
        } else {
            return a*calNode(nx-1,ny,arr, a)+a*calNode(nx,ny-1,arr, a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qNum = scanner.nextInt();
        List<Long> arrlist = new ArrayList<>();

        for (int q = 0; q < qNum; q++) {
            int a = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr[0][i] = scanner.nextInt();
            }
            if (n == 1) {
                long result = arr[0][0]%1000000007;
                arrlist.add(result);
                continue;

            }
            int[] weight = new int[n];
            if (n == 1) {
                weight[0] = 1;
            }
            if (n >= 2) {
                weight[n-1] = 1;
                weight[n-2] = 2;
            }

            for (int i = n - 3; i > 0; i--) {
                weight[i] = weight[i-1]*weight[i - 1];
                weight[i] %= 1000000007;
            }

            long sum = 0;
            for (int i = n - 1; i > 0; i--) {
               sum += a*weight[i]*arr[i][0];
                while (sum > 1000000007) {
                    sum -= 1000000007;
                }
                sum += a*weight[i]*arr[0][i];
                while (sum > 1000000007) {
                    sum -= 1000000007;
                }
            }
            arrlist.add(sum);
        }
        for (int i = 0; i < arrlist.size(); i++) {
            System.out.println("case "+ (i+1)+": "+arrlist.get(i));

        }




    }
}
