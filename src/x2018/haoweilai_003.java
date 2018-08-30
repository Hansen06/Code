package x2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class haoweilai_003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<String> res = new ArrayList<>();
        appear(arr, 0, res);
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    private static void appear(int[] bol, int pos, ArrayList<String> res) {
        if (pos == bol.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bol.length; i++) {
                if (bol[i] == 1){
                    sb.append(i);
                }
            }
            if (!res.contains(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }

        if (bol[pos] == 0){
            appear(bol, pos+1, res);
            bol[pos] = 1;
            appear(bol, pos+1, res);
            bol[pos] = 0;
        }else {
            appear(bol, pos+1, res);
        }
    }
}
