package x2018.dianxin;

import java.util.Scanner;

public class dianxin01 {
    public static int reverseInt(int n) {
        long x = 0;
        int y = 0;
        if (n >= 0) {
            y = (n + "").length();//正数
        } else {
            y = (n + "").length() - 1;//负数有一个负号
        }
        while (n != 0) {
            for (int i = 0; i < y; i++) {
                int cur = n % 10;//当前最后一位数字 ，负数则显示的是负数-25%10 等于 -5
                n = (n - cur) / 10;//把最后一位数字剔除掉的新数字
                x += (int) (cur * Math.pow(10, y - i - 1));  //相当于将每次的最后一位乘以当前位在十进制中的权重。234 = 2*10^2+3*10^1+4*10^0
            }
        }
        if ((x > Math.pow(2, 31) - 1) || (x < (-1) * Math.pow(2, 31))) {  //超过范围的返回0
            return 0;
        }
        return (int) x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(reverseInt(n));
        }

    }
}
