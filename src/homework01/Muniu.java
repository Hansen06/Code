package homework01;

import java.util.Scanner;

/**
 * 有一头母牛，它每年年初生一头小母牛。
 * 每头小母牛从第四个年头开始，
 * 每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 */
public class Muniu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    private static int f(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if (n == 3){
            return 3;
        }else {
            return f(n-1) + f(n-3);
        }
    }
}
