package basic_class_07;


public class Code_09_Knapsack {

    public static int maxValue1(int[] c, int[] p, int bag) {
        return process1(c, p, 0, 0, bag);
    }

    public static int process1(int[] c, int[] p, int i, int cost, int bag) {
        if (cost > bag) {
            return Integer.MIN_VALUE;
        }
        if (i == c.length) {
            return 0;
        }
        return Math.max(process1(c, p, i + 1, cost, bag), p[i] + process1(c, p, i + 1, cost + c[i], bag));
    }

    public static int maxValue2(int[] w, int[] v, int bag) {
        int[][] dp = new int[w.length + 1][bag + 1];
        for (int i = w.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + w[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i + 1][j + w[i]]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] w = { 3, 2, 4, 7 };
        int[] v = { 5, 6, 3, 19 };
        int bag = 11;
//        System.out.println(maxValue1(c, p, bag));
        System.out.println(maxValue2(w, v, bag));
    }

}
