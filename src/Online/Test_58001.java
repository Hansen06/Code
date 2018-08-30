package Online;

import java.util.Scanner;

public class Test_58001 {


    public static int getCount(int[] arr, int target) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        int length = arr.length;
        int[] sign = {-1, 1};
        count = getCountCore(arr, length, 0, count, target, sign);
        return count;
    }

    private static int getCountCore(int[] arr, int current, int sum, int count, int target, int[] sign) {
        if (current == 0) {
            if (sum == target) {
                count++;
            }
        } else {
            current = current - 1;
            if (current == 0) {
                count = getCountCore(arr, current, sum + arr[current], count, target, sign);
            } else {
                for (int i = 0; i < 2; i++) {
                    count = getCountCore(arr, current, sum + (sign[i] * arr[current]), count, target, sign);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(getCount(arr, target));

        int[] arr1 = {1, 2, 3, 4};
        int target1 = 5;
        System.out.println(getCount(arr1, target1));
        System.out.println(getCount(arr1, 1));

//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
//
//        char[] y_360_arr = input.toCharArray();
//
//        int[] arr_num = new int[26];
//
//        for (int i = 0; i < y_360_arr.length; i++) {
//            arr_num[y_360_arr[i]-'a']++;
//        }
//
//        for (int i = 0; i < arr_num.length; i++) {
//            System.out.print(arr_num[i] + " ");
//        }
//
//        for (int i = 0; i < 3; i++) {
//            int max = 0;
//            int result = 0;
//            for (int j = 0; j < arr_num.length; j++) {
//                if (arr_num[j] > max){
//                    result = j;
//                    max = arr_num[j];
//                }
//            }
//            arr_num[result] = 0;
//            System.out.print((char)(result+'a'));
//        }
    }
}
