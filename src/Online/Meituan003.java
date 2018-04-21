package Online;

import java.util.Scanner;

public class Meituan003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int count = 0, n1 = m;
            int res = 0;
            int time = 10, time2 = 1;

            if (m < 10) {
                res = m;
            } else {
                while (n1 >= 10) {
                    count++;
                    n1 = n1 % 10 + n1 / 10;
                }
                int count2 = count;
                while (count > 0) {
                    res += time * time2;
                    time *= 10;
                    time2++;
                    count--;
                }

                int temp2 = m - (int) Math.pow(10, count2) + 1;
                res += temp2 * (count2 + 1);
                res -= 1;
            }
            System.out.println(res);
        }
    }
}
