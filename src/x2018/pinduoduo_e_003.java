package x2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大乘积
 */
public class pinduoduo_e_003 {


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        Arrays.sort(arr);
//        int m1 = arr[0]*arr[1]*arr[n-1];
//        int m2 = arr[n-1]*arr[n-2]*arr[n-3];
//        System.out.println(m1 > m2 ? m1 : m2);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(maxProduct(arr,n));
    }

    private static int maxProduct(int[] arr, int n) {
        int max1, max2, max3, min1, min2, res;
        max1 = arr[0] > arr[1] ? arr[0] : arr[1];
        max2 = arr[0] > arr[1] ? arr[1] : arr[0];
        if (arr[2] > max1){
            max3 = max2;
            max2 = max1;
            max1 = arr[2];
        }else if(arr[2] > max2){
            max3 = max2;
            max2 = arr[2];
        }else {
            max3 = arr[2];
        }
        min1 = max3;
        min2 = max2;
        for (int i = 3; i < n; i++) {
            if (arr[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i] > max2){
                max3 = max2;
                max2 = arr[i];
            }else if (arr[i] > max3){
                max3 = arr[i];
            }
            if (arr[i] < min1){
                min2 = min1;
                min1 = arr[i];
            }else if(arr[i] < min2){
                min2 = arr[i];
            }
        }
        res = max1*max2*max3 > min1*min2*max1 ? max1*max2*max3 : min1*min2*max1;
        return res;
    }
}
