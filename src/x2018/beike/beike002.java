package x2018.beike;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class beike002 {

    public static class Mycomparator implements Comparator<node> {

        @Override
        public int compare(node o1, node o2) {
            return  o1.x - o2.x;
        }
    }
    public static class Mycomparator1 implements Comparator<node> {

        @Override
        public int compare(node o1, node o2) {
            return  o1.cnt - o2.cnt;
        }
    }


    public static class node {
        int x;
        int h;
        int cnt;
        int ans;
        int Max;
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public int getAns() {
            return ans;
        }

        public void setAns(int ans) {
            this.ans = ans;
        }

        public int getMax() {
            return Max;
        }

        public void setMax(int max) {
            Max = max;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dis = new int[100005];
        int[] vis = new int[100005];
        node[] arr = new node[100005];
        for (int i = 0; i < n; i++) {
            node nd = new node();
            int x = sc.nextInt();
            int h = sc.nextInt();
            nd.x = x;
            nd.h = h;
            nd.cnt = i;
            nd.ans = 1;
            nd.Max = nd.x + nd.h - 1;
            arr[i] = nd;

        }
        Arrays.sort(arr, new Mycomparator());
        for (int i = n-1; i >= 1; i--){
            int j = i+1;
            int Max = arr[i].Max;
            while (j <= n && arr[j].x <= Max){
                arr[i].ans += arr[j].ans;
                Max = Math.max(Max, arr[j].Max);
                j += arr[j].ans;
            }
            arr[i].Max = Max;
        }
        Arrays.sort(arr, new Mycomparator1());
        for (int i = 1; i < n; i++)
            System.out.println(arr[i].ans);
        System.out.println(arr[n].ans);

    }
}
