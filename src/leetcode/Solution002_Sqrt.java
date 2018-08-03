package leetcode;

/**
 * 求平方根
 */
public class Solution002_Sqrt {

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public static int mySqrt1(int x) {
        if (x == 0)
            return 0;

        final double _JINGDU = 1e-6;

        double left = 0.0;
        double right = x;
        double mid = Double.MAX_VALUE;
        double last_mid = Double.MIN_VALUE;
        while (Math.abs(mid - last_mid) > _JINGDU) {
            last_mid = mid;
            mid = left + (right-left)/2;
            if (mid*mid < x) {
                left = mid;
            }
            if (mid*mid > x){
                right = mid;
            }
        }
        return (int)mid;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(16));

        System.out.println("----------------------");
//        System.out.println(mySqrt1(4));
        System.out.println(mySqrt1(1));
        System.out.println(mySqrt1(8));
        System.out.println(mySqrt1(16));

    }

}
