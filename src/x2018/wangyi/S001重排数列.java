package x2018.wangyi;

import java.util.Scanner;

public class S001重排数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                arr[j] = sc.nextInt();
            }

            int num4 = 0;
            int num2 = 0;
            for (int j = 0; j < num; j++) {
                if (arr[j] % 4 == 0){
                    num4++;
                }else if (arr[j] % 2 == 0){
                    num2++;
                }
            }
            if (num2 == 0){
                if (num4 >= num / 2){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else {
                if (num2 >= (num - 2 * num4)){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }
}
