package utils;

public class GCD_LCM {

    public static int get_gcd(int m, int n){
        if (m < n){
            int temp = n;
            n = m;
            m = temp;
        }
        while(n != 0){
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static int get_lsm(int m, int n){
        return m*n/get_gcd(m,n);
    }

    public static void main(String[] args) {
        System.out.println(get_gcd(2,4));
        System.out.println(get_gcd(4,12));
    }
}
