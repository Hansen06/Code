package x2018.xiaomi;

import java.util.Scanner;

/**
 * 小米之家是成人糖果店。里面有很多便宜，好用，好玩的产品。中秋节快到了，小米之家想给米粉们准备一些固定金额大礼包。对于给定的一个金额，需要判断能不能用不同种产品（一种产品在礼包最多出现一次）组合出来这个金额。聪明的你来帮帮米家的小伙伴吧。
 *
 * 输入
 * 输入 N （N 是正整数， N  <= 200）
 *
 * 输入 N 个价格p（正整数, p <= 10000）用单空格分割
 *
 * 输入金额 M（M是正整数，M <= 100000 ）
 *
 * 输出
 * 能组合出来输出 1
 *
 * 否则输出 0
 *
 *
 * 样例输入
 * 6
 * 99 199 1999 10000 39 1499
 * 10238
 * 样例输出
 * 1
 */
public class xiaomi01 {

    public static void main(String[] ab) {
        Scanner in = new Scanner(System.in);
        boolean res;
        int _p_size = 0;
        _p_size = Integer.parseInt(in.nextLine().trim());
        int[] _p = new int[_p_size];
        int _p_item;
        String []_ps = in.nextLine().split(" ");
        for(int _p_i = 0; _p_i < _p_size; _p_i++) {
            _p_item = Integer.parseInt(_ps[_p_i]);
            _p[_p_i] = _p_item;
        }

        int _M;
        _M = Integer.parseInt(in.nextLine().trim());

//        res = miHomeGiftBag(_p, _M);
//        System.out.println(String.valueOf(res ? 1 : 0));
    }

}
