package x2018;

import java.util.Scanner;

/**
 * 赛码 360 最强大脑
 */
public class y_360_zuiqiangdanao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String seq = sc.next();
            String first = sc.next();
            String second = sc.next();
            boolean forward = false;
            boolean backward = false;

            forward = judge(seq, first, second);
            backward = judge(new StringBuilder(seq).reverse().toString(), first, second);
            if (forward && backward) {
                System.out.println("both");
            } else if (forward) {
                System.out.println("forward");
            } else if (backward) {
                System.out.println("backward");
            } else {
                System.out.println("invalid");
            }
        }

    }

    private static boolean judge(String seq, String first, String second) {
        boolean flag = false;

        int len_f = first.length();
        int len_s = second.length();
        int pos = 0;
        boolean truth = false;
        while (pos < seq.length()) {
            if (pos + len_f <= seq.length()) {
                if (seq.substring(pos, pos + len_f).equals(first)) {
                    truth = true;
                    break;
                }
            }
            pos++;
        }
        if (truth) {
            pos += len_f;
            while (pos < seq.length()) {
                if (pos + len_s <= seq.length()) {
                    if (seq.substring(pos, pos + len_s).equals(second)) {
                        flag = true;
                        break;
                    }
                }
                pos++;
            }
        }
        return flag;
    }

}
