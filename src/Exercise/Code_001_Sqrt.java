package Exercise;

import java.util.Map;

public class Code_001_Sqrt {

    public static double MySqrt(double n){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }

        double low = 0;
        double high = n;
        double mid = Double.MAX_VALUE;
        double last_mid = Double.MIN_VALUE;
        double jingDu = 1e-6;
        while (Math.abs(mid - last_mid) > jingDu){
            last_mid = mid;
            mid = (high+low)/2;
            if (mid*mid > n){
                high = mid;
            }
            if (mid*mid < n){
                low = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {

        double n = 3;
        System.out.println(MySqrt(n));

    }
}
