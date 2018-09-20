package x2018.xiaomi;

import java.util.Scanner;

/**
 * 依次给出n个正整数A1，A2，… ，An，将这n个数分割成m段，每一段内的所有数的和记为这一段的权重，
 * m段权重的最大值记为本次分割的权重。问所有分割方案中分割权重的最小值是多少？
 * <p>
 * 输入
 * 第一行依次给出正整数n，m，单空格切分；(n <= 10000, m <= 10000, m <= n)
 * 第二行依次给出n个正整数单空格切分A1，A2，… ，An  (Ai <= 10000)
 * 输出
 * 分割权重的最小值
 * <p>
 * <p>
 * 样例输入
 * 5 3
 * 1 4 2 3 5
 * 样例输出
 * 5
 * <p>
 * Hint
 * 分割成 1  4 |   2   3  |   5  的时候，3段的权重都是5，得到分割权重的最小值。
 */
public class xiaomi02 {

    public static void main(String[] ab) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = in.nextInt();
            arr[i] = tmp;
        }

    }

}
