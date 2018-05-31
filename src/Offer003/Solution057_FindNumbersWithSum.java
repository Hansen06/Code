package Offer003;

import java.util.ArrayList;

/**
 *和为S的两个数字
 */
public class Solution057_FindNumbersWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length < 2){
            return result;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high){
            int curSum = array[low] + array[high];
            if (curSum == sum){
                result.add(array[low]);
                result.add(array[high]);
                break;
            }else if (curSum > sum){
                high--;
            }else {
                low++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,4,7,11,15};
        int[] arr1 = {};
        ArrayList<Integer> res = new ArrayList<>();
        res = FindNumbersWithSum(arr1,0);
        System.out.println(res);
//        System.out.println(res.get(0));
//        System.out.println(res.get(1));
    }
}



