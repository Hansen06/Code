package company.wangyi;

import java.util.Scanner;

public class S002游历魔法王国 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int step = sc.nextInt();
        int[] parent = new int[num-1];
        for (int i = 0; i < num-1; i++) {
            parent[i] = sc.nextInt();
        }

        int[] dp = new int[200];
        int max = 0;
        for (int i = 0; i < num - 1; i++) {
            dp[i+1] = dp[parent[i]] + 1;
            max = Math.max(max, dp[i+1]);
        }

        int depth = Math.min(step, max);
        System.out.println(Math.min(num, 1 + depth + (step-depth)/2));

    }
}
