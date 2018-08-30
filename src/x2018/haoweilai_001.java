package x2018;

import java.util.ArrayList;
import java.util.Scanner;

public class haoweilai_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] ch = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        split(ch, 0, res);
        for (int i = 0; i < res.size(); i++) {

        }
    }

    private static void split(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
            return;
        }
        split(chs, i + 1,res);
        char tmp = chs[i];
        chs[i] = 0;
        split(chs, i + 1, res);
        chs[i] = tmp;
    }
}
