package x2018;

/**
 * 在平面直角坐标系上，从(x1, y1)到(x2, y2)有多少条路径，使得
 * <p>
 * a) 对路径上经过每一点(x, y)，x和y至少有一个是整数。
 * <p>
 * b) 路径的长度最短，为 |x1 – x2| + |y1 – y2|
 * <p>
 * c) 对于路径上的每一点(x, y)，都保证 x <= y
 * <p>
 * <p>
 * 这个答案可能很大，只需要输出它对质数(1e9 + 7)取模的结果即可
 */

// https://blog.csdn.net/x_iya/article/details/78536132

import java.util.Scanner;

public class didi002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println(getAllPath(x1, y1, x2, y2));
    }

    private static int getAllPath(int x1, int y1, int x2, int y2) {
        if (x1 > y1 || x2 > y2) {
            return 0;
        }
        int count = 0;
        if (x1 == y1 && x1 == 0 && x2 == y2 && x2 == 0) {
            count = 1;
        }
        if (x1 == y1 && x1 == 0 && x2 == y2 && x2 == 1) {
            count = 1;
        }
        return count;
    }
}
