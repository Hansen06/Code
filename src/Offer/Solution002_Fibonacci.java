package Offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。 n<=39
 */
public class Solution002_Fibonacci {

    public static int Fibonacci(int n) {
        if(n < 0){
            return -1;
        }
        if(n == 0){
            return 0;
        }
        if( n == 1){
            return 1;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }

    }

    public static int Fibonacci1(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int result = 0;
        int f_1 = 1;
        int f_2 = 0;
        int flag = 1;
        while (flag < n){
            result = f_1 + f_2;
            f_2 = f_1;
            f_1 = result;
            flag++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci1(6));
    }
}
