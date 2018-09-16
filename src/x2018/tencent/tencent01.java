package x2018.tencent;

import java.util.Scanner;

/**
 *
 */
public class tencent01 {

    public static int gcd(int a, int b) {
        int i;
        while (a % b != 0)//辗转相除求最大公约数
        {
            i = a % b;
            a = b;
            b = i;
        }
        return b;
    }

    public static int gbd(int a, int b) {
        return a / gcd(a, b) * b;//防溢出 求最小公倍数
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int s1 = n + 1;
        for (int i = n + 2; ; ++i) {
            s1 = gbd(s1, i);

            int s = 1;
            for (int j = 2; j < i; ++j) {
                s = gbd(s, j);
            }
            if (s == s1){
                System.out.println(i);
                break;
            }
        }

    }
}
