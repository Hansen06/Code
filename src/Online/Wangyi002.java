package Online;

import java.util.Scanner;

public class Wangyi002 {

//    // 方法一：矩阵在X,Y轴上的投影都在另一矩形投影的一侧，则矩阵必定无交集；否则，有交集。
//    boolean isRectIntersect(Rectangle a, Rectangle b) {
//        // 需要排除特殊情况：一个矩形在另一个矩形内
//        if ((a.top < b.top && a.bottom > b.bottom && a.right < b.right && a.left > b.left) || (b.top < a.top && b.bottom > a.bottom && b.right < a.right && b.left > a.left)) {
//            return false;
//        }
//        if ((a.top < b.bottom && a.right < b.left) || (a.bottom > b.top && a.left > b.right)) {
//            return false;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] x1 = new int[t];
        int[] y1 = new int[t];
        int[] x2 = new int[t];
        int[] y2 = new int[t];



    }
}
