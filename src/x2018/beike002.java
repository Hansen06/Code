package x2018;

import java.util.Scanner;

public class beike002 {
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
                int max = arr[i];
                int min = arr[i];
                for (int j = i; j <= i + rang; j++) {
                    if (arr[j] > max){
                        max = arr[j];
                    }
                    if (arr[j] < min){
                        min = arr[j];
                    }
                }
                subSum += (max - min);
            }
        }
        return subSum;
    }
}
