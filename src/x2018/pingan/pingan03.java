package x2018.pingan;

import java.util.Scanner;

public class pingan03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int x = 0;
        if (i > j) {
            x = i;
            i = j;
            j = x;
        }
        if (i > k) {
            x = i;
            i = k;
            k = x;
        }
        if (j > k) {
            x = j;
            j = k;
            k = x;
        }
        System.out.println("[" + i + ", " + j + ", " + k + "]");
    }
}
