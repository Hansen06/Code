package homework01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个字符串,要求输出字符串中字符所有的排列,例如输入"abc",
 * 得到"abc","acb","bca","bac","cab","cba"
 */
public class quanpailie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> res = new ArrayList<>();
        permute(str.toCharArray(), 0, res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static void permute(char[] ch, int depth, ArrayList<String> res) {
        if (depth == ch.length){
            res.add(String.valueOf(ch));
        }
        for (int i = depth; i < ch.length; i++) {
            swap(ch, depth, i);
            permute(ch, depth + 1, res);
            swap(ch, depth, i);
        }
    }

    private static void swap(char[] ch, int index1, int index2) {
        char tmp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = tmp;
    }
}
