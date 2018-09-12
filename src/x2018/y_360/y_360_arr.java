package x2018.y_360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class y_360_arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        Set res = new HashSet();
        int i = 0;
        while (i < n - 1) {
            int fir = a[i];
            int sec = a[i+1];
            if (judge(b,fir,sec)){
                res.add(fir);
                res.add(sec);
            }else {
                i += 2;
            }
            i++;
        }
        System.out.println(res.size());
    }

    private static boolean judge(ArrayList<Integer> b, int fir, int sec) {
        boolean flag = false;
        int fir_index = b.indexOf(fir);
        int sec_index = b.indexOf(sec);
        if (fir_index > sec_index){
            flag = true;
        }
        return flag;
    }
}
