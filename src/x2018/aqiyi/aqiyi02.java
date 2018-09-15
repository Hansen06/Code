package x2018.aqiyi;

import java.util.Scanner;

/**
 * 库特君在吃面条！
 *
 * 他将面条放在了数轴上，每根面条对应数轴上的两个点a和b，他想知道在任意两根面条不重叠(端点可以重叠）的情况下最多能选出多少根面条。
 *
 * 1 <= n <= 100
 *
 * -999 <= a <b <= 999
 *
 * 输入
 * 第一行一个整数N
 *
 * 接下来，N行，每行2个空格分隔的整数a和b(注意：a有可能大于b)
 *
 * 输出
 * 一个数的答案
 *
 *
 * 样例输入
 * 3
 * 6  3
 * 1  3
 * 2  5
 * 样例输出
 * 2
 */
public class aqiyi02 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            if(tmp1 < tmp2){
                a[i] = tmp1;
                b[i] = tmp2;
            }else{
                a[i] = tmp2;
                b[i] = tmp1;
            }
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (b[j] < b[i]){
                    swap(b, i, j);
                    swap(a, i, j);
                }
            }
        }
        int s = a[0];
        int e = b[0];
        for (int i = 1; i < n; i++) {
            if (a[i] >= e){
                res++;
                e = b[i];
            }
        }
        System.out.println(res);
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
