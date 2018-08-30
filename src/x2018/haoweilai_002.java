package x2018;

import java.util.ArrayList;
import java.util.Scanner;

public class haoweilai_002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int k = sc.nextInt();
            long y = satis(x, k);
            System.out.println(y);
        }
    }

    private static Long satis(int x, int k) {
        ArrayList<Long> res = new ArrayList<>();
        int flag = k;
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            if (flag < 0){
                break;
            }
            if ((x + i) == (x | i)) {
                res.add(i);
            }
            flag--;
        }
        return res.get(k);
    }
}
