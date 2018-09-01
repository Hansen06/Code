package homework01;

/**
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
 *
 * 给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
 *
 * 测试样例：
 * [1,2,3,-6,1]
 * 返回：6
 */
public class MaxSum {
    public static int getMaxSum(int[] A, int n) {
        if (A == null || n == 0){
            return 0;
        }
        int cur = 0;
        int max = A[0];
        for (int i = 0; i < n; i++) {
            cur += A[i];
            if (cur >= max){
                max = cur;
            }
            if (cur <0 ){
                cur = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,-6,1};
        System.out.println(getMaxSum(A,5));

        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(getMaxSum(arr1, arr1.length));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(getMaxSum(arr2, arr2.length));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(getMaxSum(arr3, arr3.length));

    }
}
