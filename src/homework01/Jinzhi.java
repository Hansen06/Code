package homework01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 输入描述:
    输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 输出描述:
    为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 示例1
    输入
        7 2
    输出
        111
 */
public class Jinzhi {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String m = in.next();
//        int n = in.nextInt();
//        BigInteger bi = new BigInteger(m, 10);
//        System.out.println(bi.toString(n).toUpperCase());
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String  s = "";
        String[] table = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        if(m == 0){
            System.out.println("0");
        }
        while(Math.abs(m) > 0){
            if(m < 0) {
                m = -m;
                System.out.print("-");
            }
            s = table[m%n] + s;
            m = m/n;
        }
        System.out.println(s);
    }
}