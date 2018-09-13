package x2018.souhu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 求str2是否是str1的兄弟串    如 abc 的兄弟子串 acb cba cab ; ab 不是ab的兄弟子串， aa是aa的子串
 */
public class souhu001 {

    public static ArrayList<String> getAllPermutations(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process(chs, i + 1, res);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.next();
        String str2 = in.next();

        ArrayList<String> res = new ArrayList<>();
        res = getAllPermutations(str1);
        if (res.contains(str2)){
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }
}
