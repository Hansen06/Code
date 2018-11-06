package leetcode;

/**
 * 718. Maximum Length of Repeated Subarray
 */
public class Solution718_MaximumLengthofRepeatedSubarray {
    public static int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : 0);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }
}
