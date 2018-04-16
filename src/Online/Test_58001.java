package Online;

import java.util.Scanner;

public class Test_58001 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] arr = input.toCharArray();

        int[] arr_num = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr_num[arr[i]-'a']++;
        }

        for (int i = 0; i < arr_num.length; i++) {
            System.out.print(arr_num[i] + " ");
        }

        for (int i = 0; i < 3; i++) {
            int max = 0;
            int result = 0;
            for (int j = 0; j < arr_num.length; j++) {
                if (arr_num[j] > max){
                    result = j;
                    max = arr_num[j];
                }
            }
            arr_num[result] = 0;
            System.out.print((char)(result+'a'));
        }
    }
}
