package x2018;

import java.util.Scanner;

public class pinduoduo_001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hp = in.nextInt();
        int normal = in.nextInt();
        int bufferd = in.nextInt();
        int nor_num = 0;
        if (hp % normal == 0){
            nor_num = hp / normal;
        }else {
            nor_num = hp / normal + 1;
        }
        int buf_num = 0;
        if (hp % bufferd == 0){
            buf_num = (hp/bufferd) * 2;
        }else {
            buf_num = (hp/bufferd)*2 + 1;
        }
        System.out.println(buf_num > nor_num ? nor_num : buf_num);
    }
}
