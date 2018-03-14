package homework01;

import java.util.Scanner;

public class Zero_ {


    public static int zeroNum(int num){
        if (num == 0){
            return 1;
        }

        int total = 0;
        while(num > 0){
            total = total + num/5;
            num = num/5;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(zeroNum(n));

    }
}
