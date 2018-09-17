package x2018.y_360;

/**
 * 现给出一个序列A和一个序列B。    现在小明想计算每一个数的威力值是多少，威力值的定义如下：
 *
 * 1.     我们定义l[i] = i ,r[i]=i-B[i]+1
 *
 * 2.     Query_min(l,r)，保证r>=l，表示从A[l],A[l+1],A[l+2],……,A[r-1],A[r]中取得最小值。Query_max(l,r)同理，只不过取的是最大值。
 *
 * 3.     威力值P[i] = Query_min(l[i],r[i])*Query_max(l[i],r[i])
 *
 * (实际上威力值的计算方式可以理解为：P[i] = min(A[i],A[i-1]…A[i-B[i]+1])*max(A[i],A[i-1]….A[i-B[i]+1]) )
 *
 * 现在小明想知道每个数的威力值是多少，你能告诉他吗？
 *
 * 输入
 * 第一行一个整数N
 *
 * 接下来一行N个整数，分别表示A[i]
 *
 * 接下来一行N个整数，分别表示B[i]
 *
 * 题目保证B[i] <= i , |A[i]|<=10^9
 *
 * 输出
 * 输出 N 行，依次表示第i个位置的威力值
 *
 *
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 1 2 1 2 3
 * 样例输出
 * 1
 * 2
 * 9
 * 12
 * 15
 */

import java.util.Arrays;
import java.util.Scanner;

public class y_360_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        
        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = i - B[i] + 1;
            int[] t = new int[i - tmp + 1];
            int index = 0;
            for (int j = i; j >= tmp ; j--) {
                t [index] = A[j];
                index++;
            }
            Arrays.sort(t);
            int min = t[0];
            int max = t[t.length - 1];
            P[i] = min*max;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(P[i]);
        }

    }
}
