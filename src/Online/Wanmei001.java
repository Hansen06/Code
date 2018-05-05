package Online;

import java.util.Scanner;

public class Wanmei001 {

    public static int maxValue(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }
        int[] time = new int[num];
        for (int i = 0; i < num; i++) {
            time[i] = sc.nextInt();
        }

        int total_time = sc.nextInt();

        System.out.println(maxValue(score, time, total_time));
    }

}

