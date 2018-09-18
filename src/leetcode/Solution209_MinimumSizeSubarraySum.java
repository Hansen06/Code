package leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class Solution209_MinimumSizeSubarraySum {

    private static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];

            while (sum >= s) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) {
                break;
            }
            if (end - i < minLen) {
                minLen = end - i;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen(s, arr));
        System.out.println(solveNLogN(s, arr));
    }
}
