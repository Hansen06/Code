package Online;

import java.util.Scanner;

public class Test_58002 {


    public static int getResult(int[] arr, int start, int length, int sum){

        for (int i = start; i < length; i++) {
            getResult(arr, i + 1, length - 1, sum - arr[i]);

        }
        return 1;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();


    }
}
