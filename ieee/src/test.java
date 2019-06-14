import java.text.DecimalFormat;
import java.util.Scanner;

class Main {

    public static String aliceNumber(long n) {
        double maxRe = 0;
        long endx = 0;
        long endy = 0;
        long endz = 0;
        for (long x = 1; x <= n/3; x++) {
            long temp = (n-x)/2;
            for (long y = x; y <= temp; y++) {
                long z = n - x - y;
                System.out.println("x="+x+" y="+y+" z="+z);
                double re =  Math.sin(x) + Math.sin(y) + Math.sin(z);
                if (re > maxRe) {
                    endx = x;
                    endy = y;
                    endz = z;
                    maxRe = re;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.000000000");
        System.out.println("--------------------------------");
        System.out.println("x="+endx+" y="+endy+" z="+endz);
        return df.format(maxRe);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        System.out.println(aliceNumber(n));
    }
}
