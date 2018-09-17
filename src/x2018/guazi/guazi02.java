package x2018.guazi;

import java.util.Scanner;

/**
 *最大储水量
 */
public class guazi02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        System.out.println(getWater1(h));
        System.out.println(getWater(h));
    }

    public static int getWater1(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                value += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                value += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return value;
    }

    public static int getWater(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int value = 0;
        if (arr[0] < 0){
            value -= arr[0];
        }
        if (arr[arr.length - 1] < 0){
            value -= arr[arr.length - 1];
        }
        for (int i = 1; i < arr.length - 1; i++) {

            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return value;
    }
}
