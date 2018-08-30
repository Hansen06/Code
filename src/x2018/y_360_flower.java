package x2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class y_360_flower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = sc.nextInt();
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(quare(a,l,r));
        }

    }

    private static int quare(int[] a, int l, int r) {
        Set set = new HashSet();
        for (int i = l; i <= r; i++) {
            set.add(a[i]);
        }
        return set.size();
    }
}
