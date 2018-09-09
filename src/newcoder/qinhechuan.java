package newcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/ca68cb11b1a94ddeb3181274d4e94760
 */
public class qinhechuan {

    public static int[] getNextArr(char[] ch){
        if (ch.length == 1){
            return new int[] { -1 };
        }
        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        for (int i = 2; i < ch.length; i++) {
            if (ch[i-1] == ch[cn]){
                next[i] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[i] = 0;
            }
        }
        return next;
    }

    public static int judge(char[] ch1, char[] ch2, int[] next){
        int l1 = 0;
        int l2 = 0;
        while(l1 < ch1.length && l2 < ch2.length){
            if (ch1[l1] == ch2[l2]){
                l1++;
                l2++;
            }else if(next[l2] == -1){
                l1++;
            }else {
                l2 = next[l2];
            }
        }
        return l2 == ch2.length ? l1 - l2 : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            str1 = str1 + str1;
            if (str1.length() < str2.length()) {
                System.out.println("no");
            } else {
                char[] ch1 = str1.toCharArray();
                char[] ch2 = str2.toCharArray();
                int[] next = getNextArr(ch2);
                int res = judge(ch1, ch2, next);
                if (res != -1) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

}
