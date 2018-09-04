package x2018.beike;

import java.util.Scanner;

public class beike001 {

    public static int getFactors(int n) {
        int count = 0;

        if (n == 0){
            return count;
        }else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    count += 2;
                }
            }
            return ++count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFactors(n));


    }
}
