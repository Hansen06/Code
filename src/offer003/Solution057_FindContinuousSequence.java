package offer003;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 */
public class Solution057_FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (sum < 3){
            return result;
        }

        int low = 1;
        int high = 2;
        int mid = (1 + sum) / 2;
        int curSum = low + high;
        while (low < mid){
            ArrayList<Integer> curResult = new ArrayList<>();
            if (curSum == sum){
                for (int i = low; i <= high; i++) {
                    curResult.add(i);
                }
                result.add(curResult);
            }
            while (curSum > sum && low < mid){
                curSum -= low;
                low++;

                if (curSum == sum) {
                    for (int i = low; i <= high; i++) {
                        curResult.add(i);
                    }
                    result.add(curResult);
                }
            }
            high++;
            curSum += high;
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = FindContinuousSequence(100);
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
