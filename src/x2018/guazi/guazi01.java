package x2018.guazi;

import java.util.Scanner;

/**
 *有1分,2分,5分,10分四种硬币，每种硬币数量无限，给定n分钱，求有多少种组合可以组合成n分钱？
 */
public class guazi01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
    }

    private static int count(int n) {
        int[] coins = {1, 2, 5, 10};
        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }
}
