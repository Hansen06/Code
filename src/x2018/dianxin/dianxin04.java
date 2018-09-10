package x2018.dianxin;

import java.math.BigInteger;
import java.util.Scanner;

public class dianxin04 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            BigInteger fac = new BigInteger("1");
            int n = sc.nextInt();
            for (int i = 2; i <= n; i++)
                fac = fac.multiply(new BigInteger("" + i));
            long sum = 0;
            String str = fac.toString();
            for (int i = 0; i < str.length(); i++)
                sum += str.charAt(i) - '0';
            System.out.println(sum);
        }
    }
}
