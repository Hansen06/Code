package homework01;

import java.math.BigInteger;
import java.util.Scanner;

public class Jinzhi {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String m = in.next();
//        int n = in.nextInt();
//        BigInteger bi = new BigInteger(m, 10);
//        System.out.println(bi.toString(n).toUpperCase());
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String  s = "";
        String[] table = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        if(m == 0){
            System.out.println("0");
        }
        while(Math.abs(m) > 0){
            if(m < 0) {
                m = -m;
                System.out.print("-");
            }
            s = table[m%n] + s;
            m = m/n;
        }
        System.out.println(s);
    }
}