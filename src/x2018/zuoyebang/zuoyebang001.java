package x2018.zuoyebang;

import java.util.Scanner;

public class zuoyebang001 {

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
