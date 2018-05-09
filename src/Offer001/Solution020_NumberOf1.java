package Offer001;

/**
 * 二进制为1的个数
 */

public class Solution020_NumberOf1 {
    public static int NumberOf1(int n){
        if (n == 0){
            return 0;
        }
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static int NumberOf11(int n){
        if (n == 0){
            return 0;
        }
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int NumberOf12(int n){
        if (n == 0){
            return 0;
        }

        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1)&n;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(NumberOf1(4));
        System.out.println(NumberOf1(3));
        System.out.println(NumberOf1(-5));
        System.out.println(NumberOf1(-2147483648));

        System.out.println();

        System.out.println(NumberOf11(4));
        System.out.println(NumberOf11(3));
        System.out.println(NumberOf11(-5));
        System.out.println(NumberOf11(-2147483648));

        System.out.println();

        System.out.println(NumberOf12(4));
        System.out.println(NumberOf12(3));
        System.out.println(NumberOf12(-5));
        System.out.println(NumberOf12(-2147483648));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-2147483648));
    }
}
