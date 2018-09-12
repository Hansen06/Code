package x2018.xunlei;

import java.util.Scanner;

public class xunlie03 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        int[] num = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.valueOf(arr[i]);
            sum += num[i];
        }

        int[] left = new int[num.length];
        int[] right = new int[num.length];
        left[0] = 0;
        right[0] = sum - num[0];
        for (int i = 1; i < num.length; i++) {
            left[i] = num[i-1] + left[i-1];
            right[i] = right[i-1] - num[i];
        }

        for (int i = 0; i < num.length; i++) {
//            System.out.println(right[i]);
            if (left[i] == right[i]){
                System.out.println(i);
                break;
            }
        }

    }
}
