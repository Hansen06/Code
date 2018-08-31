package x2018;

import java.util.Scanner;

public class pinduoduo_cp_001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt();
        int normal = in.nextInt();
        int bufferd = in.nextInt();
        int num = attack(hp, normal, bufferd, false, 0, 0);
        System.out.println(num);
    }

    private static int attack(int hp, int normal, int bufferd, boolean flag, int att, int noatt) {
        if (hp == 0){
            return 0;
        }

        if (flag){
            attack(hp-normal, normal, bufferd, false, att, noatt);
            attack(hp, normal, bufferd, false, att, noatt);
            att += 1;
        }else {
            attack(hp-bufferd, normal, bufferd, true, att, noatt);
            noatt += 1;
        }
        return att > noatt ? noatt:att;
    }
}
