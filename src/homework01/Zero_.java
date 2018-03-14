package homework01;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
    输入为一行，n(1 ≤ n ≤ 1000)
 输出描述:
    输出一个整数,即题目所求
 示例1
    输入
        10
    输出
        2
 */
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
