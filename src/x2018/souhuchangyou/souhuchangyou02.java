package x2018.souhuchangyou;

import java.util.Scanner;

public class souhuchangyou02 {

    public static int dogNumber(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return dogNumber(n - 1) + dogNumber(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(dogNumber(n));
        }
    }
}
