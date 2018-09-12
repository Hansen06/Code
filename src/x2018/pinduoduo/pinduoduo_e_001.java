package x2018.pinduoduo;

import java.util.Scanner;

/**
 * 列表补全
 */
public class pinduoduo_e_001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int offset = in.nextInt();
        int n = in.nextInt();
        int l1 = in.nextInt();
        int l2 = in.nextInt();
        int[] res = new int[4];
        if (offset < l1) {
            if (l1 - offset < n) {
                res[0] = offset;
                res[1] = l1;
                res[2] = 0;
                res[3] = n - (l1 - offset);
            } else {
                res[0] = offset;
                res[1] = offset + n;
                res[2] = 0;
                res[3] = 0;
            }
        } else {
            res[0] = l1;
            res[1] = l1;
            if (offset - l1 == 0){
                res[2] = 0;
                if(n > l2){
                    res[3] = l2;
                }else {
                    res[3] = n;
                }
            }else if (offset - l1 > l2){
                res[2] = l2;
                res[3] = l2;

            }else {
                if ((l2 - (offset - l1)) < n) {
                    res[2] = offset - l1;
                    res[3] = l2;
                }else {
                    res[2] = offset - l1;
                    res[3] = (offset - l1) + n;
                }
            }
        }

        for (int j = 0; j < 3; j++) {
            System.out.print(res[j] + " ");
        }
        System.out.println(res[3]);
    }
}
