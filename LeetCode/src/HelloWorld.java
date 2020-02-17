
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/08/30 14:12
 */

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(2));

    }

    public static double forceWork(double[] x, double[] y) {
        double res = Double.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
                res = Math.min(Math.sqrt((Math.pow(x[j] - x[i], 2) + Math.pow(y[j] - y[i], 2))),res);
            }
        }
        return res;
    }

    public static double mergeAndCompute(Node[] nodes, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            double d1 = mergeAndCompute(nodes, start, mid);
            double d2 = mergeAndCompute(nodes, mid + 1, end);
            double d = merge(nodes, start, mid, end,d1,d2);
            return d;
        }
        return Double.MAX_VALUE;
    }

    public static double merge(Node[] nodes, int start, int mid, int end,double d1,double d2) {
        double dis = 0;
        if (start == mid) {
            dis = Math.sqrt(Math.pow(nodes[end].x - nodes[start].x, 2) + Math.pow(nodes[end].y - nodes[start].y, 2));
        } else {
            double tempDis = Math.min(d1,d2);

//            double tempx[] = new double[end - start + 1];
//            double tempy[] = new double[end - start + 1];
            Node[] tempNodes = new Node[end - start + 1];
            int index = 0;
            for (int m = start; m <= end; m++) {
                if (Math.abs(nodes[m].x - nodes[mid].x) < tempDis) {
//                    tempx[index] = x[m];
//                    tempy[index] = y[m];
                    tempNodes[index] = nodes[m];
                    index++;
                }
            }

            if (index > 2) {
                for (int m = 0; m < index; m++) {
                    for (int n = m+1; n < index; n++) {
                        if (Math.abs(tempNodes[m].y - tempNodes[n].y) > tempDis) {
                            continue;
                        }
                        tempDis = Math.min(tempDis, Math.sqrt(Math.pow(tempNodes[m].x - tempNodes[n].x, 2) + Math.pow(tempNodes[m].y - tempNodes[n].y, 2)));
                    }
                }
            }
            dis = tempDis;
        }
        return dis;
    }

//    public static void quickSort(double[] x, double[] y, int start, int end) {
//        if(start < end){
//            // 获取分区点位置；且key左都小于arr[key],key右都大于
//            int key = partition(x, y, start, end);
//            // key值已归位，不参与递归
//            quickSort(x,y,start,key-1);
//            quickSort(x,y,key+1,end);
//        }
//    }
//
//    public static int partition(double[] x, double[] y, int start, int end) {
//        // 默认取末尾key
//        double keyX = x[end];
//        double keyY = y[end];
//        int i = start;
//        for (int j = start; j <= end; j++) {
//            if(x[j] < keyX){
//                double tmp = x[j];
//                x[j] = x[i];
//                x[i] = tmp;
//                tmp = y[j];
//                y[j] = y[i];
//                y[i] = tmp;
//                i++;
//            }else {
//                if (x[j] == keyX) {
//                    if (y[j] < keyY) {
//                        double tmp = x[j];
//                        x[j] = x[i];
//                        x[i] = tmp;
//                        tmp = y[j];
//                        y[j] = y[i];
//                        y[i] = tmp;
//                        i++;
//                    }
//                }
//                // 最后归位key
//                if (j == end) {
//                    double tmp = x[j];
//                    x[j] = x[i];
//                    x[i] = tmp;
//                    tmp = y[j];
//                    y[j] = y[i];
//                    y[i] = tmp;
//                }
//            }
//        }
//        return i;
//    }
}

class Node {
    public double x;
    public double y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


