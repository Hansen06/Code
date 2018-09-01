package homework01;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=2084
 */
public class Shuta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int[][] dp = new int[102][102];
        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[j][k] = sc.nextInt();
                }
            }
            for (int j = N; j >= 1 ; j--) {
                for (int k = j; k >= 1 ; k--) {
                    dp[j][k] += Math.max(dp[j+1][k], dp[j+1][k+1]);
                }
            }
            System.out.println(dp[1][1]);
        }

    }
}
