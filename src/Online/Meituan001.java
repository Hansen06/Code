package Online;

import java.util.Scanner;

public class Meituan001 {

    public static int get_gcd(int n1, int n2) {
        int gcd = 0;
        if (n1 < n2) {
            n1 = n1 + n2;
            n2 = n1 - n2;
            n1 = n1 - n2;
        }

        if (n1 % n2 == 0) {
            gcd = n2;
        }

        while (n1 % n2 > 0) {
            n1 = n1 % n2;

            if (n1 < n2) {
                n1 = n1 + n2;
                n2 = n1 - n2;
                n1 = n1 - n2;
            }

            if (n1 % n2 == 0) {
                gcd = n2;
            }
        }
        return gcd;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        int[] arr = new int[N];
        arr[0] = p;
        for (int i = 1; i < N; i++) {
            arr[i] = (arr[i-1] + 153)%p;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                System.out.println(get_gcd(i,j) + y_360_arr[get_gcd(i,j)]);

                result += arr[get_gcd(i,j)-1];
            }
        }
        System.out.println(result);
    }
}
