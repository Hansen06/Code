package Online;

import java.util.Scanner;

public class Kedaxunfei001 {

    public static boolean isPrime(int num){

        if (num == 2 || num == 3){
            return true;
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        if (q < 1 || q > 100000){
            return;
        }
        int[] arr = new int[100100];
        int k = 0;
        for (int i = 2; i < 100100; i++) {
            if (isPrime(i)) {
                arr[k++] = i;
            }
        }
        for (int i = 0; i < q; i++) {
            int num = sc.nextInt();
            if (num < 1 || num > 100000){
                return;
            }else {
                System.out.println(arr[num - 1]);
            }
        }
    }
}
