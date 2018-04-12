package Online;

import java.util.Scanner;

public class JD002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        if (t < 1 || t > 1000){
            return;
        }
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {

            if (arr[i]%2 != 0){
                System.out.println("No");
                continue;
            }
            if ((arr[i] & (arr[i]-1)) == 0){
                System.out.println("No");
                continue;
            }

            for (int j = 2; j <= arr[i]; j+=2){
                if (arr[i]%j == 0){
                    System.out.println(arr[i]/j + " " + j);
                    break;
                }
            }

        }
    }
}
