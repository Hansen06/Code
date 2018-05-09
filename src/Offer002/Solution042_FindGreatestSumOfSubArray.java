package Offer002;

/**
 * 连续子数组的最大和
 */
public class Solution042_FindGreatestSumOfSubArray {

    public static int FindGreatestSumOfSubArray(int[] array) {
        Integer result = null;
        if (array == null){
            return result;
        }

        int sum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0){
                curSum = array[i];
            }else {
                curSum = curSum + array[i];
            }
            if(curSum >= sum){
                sum = curSum;
            }
        }
        result = sum;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
