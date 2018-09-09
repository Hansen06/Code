package x2018.meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class meituan002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int cur = sc.nextInt();
            if (cur == 0){
                list.add(i);
            }
        }
        int maxlen = list.get(k) - 1;
        System.out.println(maxlen);
        for (int i = k + 1; i < list.size(); i++) {
            int tmp = list.get(i) - list.get(i - k - 1) - 1;
            maxlen = Math.max(tmp, maxlen);
        }
        System.out.println(maxlen);
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
