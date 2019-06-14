package cn.itcast.junit;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo1 {
    @Test
    public void getMax(){
        int a = 3;
        int b = 5;
        int max = a>b?a:b;
        System.out.println("最大值："+max);
        //Assert.assertSame(3,max);
        //throw new RuntimeException();
    }



    @Test
    public void sort() {
        int[] arr = {12,4,1,19};
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("数组元素: "+ Arrays.toString(arr));
    }
}
