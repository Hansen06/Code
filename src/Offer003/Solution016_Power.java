package Offer003;

/**
 * 数值的整数次方
 */
public class Solution016_Power {

    public static double Power(double base, int exponent) {
        if (base == 0.0 && exponent < 0){
            return 0;
        }

        int absEx = exponent;
        if (exponent < 0){
            absEx = -exponent;
        }

        double result = PowerWithExpon1(base, absEx);
        if (exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    private static double PowerWithExpon(double base, int absEx) {
        if (absEx == 0){
            return 1;
        }
        if (absEx == 1){
            return base;
        }
        double result = PowerWithExpon(base, absEx >> 1);
        result *= result;
        if ((absEx & 1) == 1){
            result = result*base;
        }

        return result;
    }
    private static double PowerWithExpon1(double base, int absEx) {
        double result = 1;
        double cur = base;
        while(absEx != 0){
            if ((absEx & 1) == 1){
                result = result*cur;
            }
            cur *= cur;
            absEx >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2,3));
    }
}
