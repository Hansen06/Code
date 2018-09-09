package x2018.jd;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class jd001 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        int res = 0;
        if (S == null || T == null){
            return 0;
        }
        char[] ch1 = S.toCharArray();
        char[] ch2 = T.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < ch2.length; i++) {
            if (!list.contains(ch2[i])) {
                list.add(ch2[i]);
            }
        }
        int ch2_len = ch2.length;
        for (int i = 0; i <= ch1.length - ch2_len; i++) {
            ArrayList<Character> set = new ArrayList<>();
            for (int j = i; j < i + ch2_len ; j++) {
                if (!set.contains(ch1[j])) {
                    set.add(ch1[j]);
                }
            }
            if (set.size() == list.size()){
                String cur = S.substring(i,i+ch2_len);
                for (int j = 0; j < list.size(); j++) {
                    cur = cur.replaceAll(String.valueOf(set.get(j)),String.valueOf(list.get(j)));
                }
                if (cur.equals(T)){
                    res++;
                }
            }
        }
        return res;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}

