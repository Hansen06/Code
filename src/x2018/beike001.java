package x2018;

import java.util.Scanner;

public class beike001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int[][] rang = new int[n][2];
        for (int i = 0; i < n; i++) {
            rang[i][0] = sc.nextInt();
            rang[i][1] = sc.nextInt();
        }

        int power = 0;
        power += (rang[0][1] - rang[0][0]) * p1;
        for (int i = 1; i < n; i++) {
            int sp = rang[i][0] - rang[i-1][1];
            if (sp > t1){
                power += t1 * p1;
                if (sp - t1 > t2){
                    power += t2 * p2;
                    power += (sp - t1 - t2) * p3;
                }else {
                    power += (sp - t1) * p2;
                }
            }else {
                power += sp * p1;
            }
            power += (rang[i][1] - rang[i][0]) * p1;
        }
        System.out.println(power);
    }
}
