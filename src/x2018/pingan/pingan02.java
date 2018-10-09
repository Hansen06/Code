package x2018.pingan;

import java.util.Scanner;

public class pingan02 {

    private static String decompose(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n != i) {
                n = n / i;
                sb.append(i + "*");
//                System.out.print(i + "*");
            }
            if (n == i) {
//                System.out.println(i);
                sb.append(i);
                break;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(decompose(n));
        }
    }
}
