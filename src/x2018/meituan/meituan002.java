package x2018.meituan;

import java.util.Scanner;

public class meituan002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int len = 0;
        getMaxSub(arr, k, 0, len);
        System.out.println(len);

    }

    private static int getMaxSub(int[] arr, int k, int cur, int len) {
        if (cur == arr.length){
            return 0;
        }
        if (arr[cur] == 1){
            len++;
        }else {
            return Math.max(getMaxSub(arr, k - 1, cur++, len++), getMaxSub(arr, k, cur++, len));
        }

        return 0;
    }
}
