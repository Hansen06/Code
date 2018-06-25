package Online;

import java.util.Scanner;

public class Kedaxunfei002 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
        }
        int sum_1 = arr[0];
        int sum_2 = arr[1];
        int flag_1 = 1;
        int flag_2 = 1;
        for (int j = 2; j < n; j++) {
            if ((sum_1 <= sum_2) && ((flag_1 - flag_2) < 2)){
                sum_1 += arr[j];
                flag_1++;
            }else if ((flag_2 - flag_1) < 2){
                sum_2 += arr[j];
                flag_2++;
            }
        }
        if (sum_1 < sum_2){
            System.out.println(sum_1 + " " + sum_2);
        }else {
            System.out.println(sum_2 + " " + sum_1);
        }
    }
}
