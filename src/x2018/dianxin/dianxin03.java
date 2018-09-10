package x2018.dianxin;

import java.util.Scanner;

public class dianxin03 {
    public static int getFactorial(int n) {
        int result = 1;
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static void getNFactorial(int n) {
        int num[] = new int[5800];
        int i, j;
        if (n == 1 || n == 0) {
            System.out.println(1);
        } else {
            int p, h;// p 存放当前结果的位数，h为进位；
            p = 1;
            h = 0;
            num[1] = 1;
            for (i = 2; i <= n; i++) {
                for (j = 1; j <= p; j++) {
                    num[j] = num[j] * i + h;
                    h = num[j] / 10;
                    num[j] = num[j] % 10;
                }
                while (h > 0) {
                    num[j] = h % 10;
                    h = h / 10;
                    j++;
                }
                p = j - 1;
            }
            for (i = p; i >= 1; i--) {
                System.out.print(num[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            getNFactorial(n);
//            System.out.println(getNFactorial(n));
        }

    }
}
