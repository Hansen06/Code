package Online;

import java.util.HashSet;
import java.util.Scanner;


/**
 * 判断是否是正方形
 * 四边相等，且对角线互相垂直
 */

public class Tencent001 {


    public static int dis(int x1, int y1, int x2, int y2) {
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] x = new int[4];
        int[] y = new int[4];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                x[j] = sc.nextInt();
            }
            for (int j = 0; j < 4; j++) {
                y[j] = sc.nextInt();
            }

            int dis_1 = dis(x[0], y[0], x[1], y[1]);
            int dis_2 = dis(x[0], y[0], x[2], y[2]);
            int dis_3 = dis(x[0], y[0], x[3], y[3]);
            int dis_4 = dis(x[1], y[1], x[2], y[2]);
            int dis_5 = dis(x[1], y[1], x[3], y[3]);
            int dis_6 = dis(x[2], y[2], x[3], y[3]);

            HashSet<Integer> set = new HashSet<>();

            set.add(dis_1);
            set.add(dis_2);
            set.add(dis_3);
            set.add(dis_4);
            set.add(dis_5);
            set.add(dis_6);

            if (!set.contains(0) && set.size() == 2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

}
