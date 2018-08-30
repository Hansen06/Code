package x2018;

import java.util.Scanner;

/**
 * 赛码 360 密码锁
 */
public class y_360_mimasuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String fir = sc.next();
            String sec = sc.next();
            String th = sc.next();
            boolean isCen = false;
            isCen = judge(fir,sec,th);
            if (isCen){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }

    private static boolean judge(String fir, String sec, String th) {
        if (fir == null && th == null && sec == null){
            return false;
        }
        boolean f1 = fir.substring(0,1).equals(th.substring(2,3));
        boolean f2 = fir.substring(1,2).equals(th.substring(1,2));
        boolean f3 = fir.substring(2,3).equals(th.substring(0,1));
        boolean f4 = sec.substring(0,1).equals(sec.substring(2,3));
        return f1 & f2 & f3 & f4;
    }

}
