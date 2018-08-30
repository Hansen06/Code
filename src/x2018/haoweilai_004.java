package x2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class haoweilai_004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[8];
        for (int i = 0; i < 8; i++) {
            data[i] = sc.nextInt();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Sum(data, 8, res);
        System.out.println(res);
    }

    private static void Sum(int[] data, int n, ArrayList<Integer> res) {
        
    }
}
