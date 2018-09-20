package x2018;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 有一个长度为N的序列 a, a中的每个元素都是属于[1, M]中的整数，且a中包含[1, M]中的所有整数。
 *
 * 如: N = 5, M = 3 的序列 a = [1, 3, 2, 3, 1]。 包含[1, 3]中的所有整数，且每个元素都属于[1, 3]。
 *
 * 当序列a的某个连续子序列同样包含[1, M]中的所有整数时，称此连续子序列为完备连续子序列。
 *
 * 现想要求长度最短的完备连续子序列的长度。
 *
 * 输入
 * 第一行是由空格隔开的两个整数分别表示 N 和 M （1 <= M <= N <= 10^5）。
 *
 * 第二行是由空格隔开的 N 个整数按顺序表示序列 a 中的所有元素。
 *
 * 输出
 * 只包含一个整数，表示完备序列的最短长度。
 *
 *
 * 样例输入
 * 10 4
 * 1 3 2 2 4 1 2 3 4 1
 * 样例输出
 * 4
 *
 * Hint
 * 样例解释
 * N = 10, M = 4, 序列 a = [1, 3, 2, 2, 4, 1, 2, 3, 4, 1]
 * 其中第6到第9元素[1, 2, 3, 4]和第7到第10元素[2, 3, 4, 1]都是最短的完备连续子序列，长度均为4。
 */
public class yitu01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minLen = getMinLen(arr,M);
        System.out.println(minLen);
    }

    private static int getMinLen(int[] arr, int m) {
        if(arr == null || arr.length < m){
            return -1;
        }
        int minLen = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        if (set.size() < m){
            return -1;
        }
        set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(arr[i]);
        }
        if (set.size() == m){
            minLen = m;
            return minLen;
        }else{
            int cur = m;
            int index = m;
            while (index < arr.length){
                set.add(arr[index]);
                cur++;
                if (set.size() == m){
                    if (cur < minLen){
                        minLen = cur;
                    }
                    set = new HashSet<>();
                    cur = 0;
                }
                index++;
            }
        }
        return minLen;
    }
}
