package x2018.zhaoshang;

import java.util.Scanner;

public class zhaoshang01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MAX_VALUE;
//        int max = 100;
        for (int i = 0; i <= max; i++) {
            if (numOfZero(i) >= n) {
                System.out.print(i + " ");
            }
        }
    }

    public static int numOfZero(int n) {
        int num = 0, i;
        for (i = 5; i <= n; i *= 5) {
            num += n / i;
        }
        return num;
    }
}
