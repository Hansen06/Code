package x2018;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class beike003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum +=subSum(arr, i);
        }
        System.out.println(sum);
    }

    public static int subSum(int[] arr, int rang){
        int subSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + rang < arr.length){
                int[] subArr = new int[rang+1];
                int k = 0;
                for (int j = i; j <= i + rang; j++) {
                    subArr[k] = arr[j];
                    k++;
                }
                Arrays.sort(subArr);
                subSum += (subArr[rang] - subArr[0]);
            }
        }
        return subSum;
    }
}
