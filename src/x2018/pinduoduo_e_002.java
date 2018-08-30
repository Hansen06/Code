package x2018;

import java.util.Scanner;

/**
 * 数三角形
 */
public class pinduoduo_e_002 {

    public static class Point{
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] point = new Point[n];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            Point p = new Point(x,y);
            point[i] = p;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (!judge1(point[i], point[j], point[k])){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean judge(Point point, Point point1, Point point2) {
        boolean flag = false;
        double len1 = Math.sqrt((point.x - point1.x)*(point.x - point1.x) + (point.y - point1.y)*(point.y - point1.y));
        double len2 = Math.sqrt((point.x - point2.x)*(point.x - point2.x) + (point.y - point2.y)*(point.y - point2.y));
        double len3 = Math.sqrt((point2.x - point1.x)*(point2.x - point1.x) + (point2.y - point1.y)*(point2.y - point1.y));
        boolean b1 = len1 + len2 > len3;
        boolean b2 = len1 + len3 > len2;
        boolean b3 = len2 + len3 > len1;
        if (b1 && b2 && b3){
            flag = true;
        }
        return flag;
    }

    private static boolean judge1(Point point1, Point point2, Point point3) {

        if (point1.x == point2.x) { // 同一条竖线
            return point1.x == point3.x;
        } else if(point1.x == point3.x) {
            return point2.x == point3.x;
        } else {
            return ((point1.y - point2.y) / (point1.x - point2.x)) == ((point3.y - point2.y) / (point3.x - point2.x));
        }
    }
}
