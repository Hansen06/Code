package Online;

import java.util.Scanner;

public class Aqi001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] cha = str.toCharArray();
        int len = cha.length;
        int maxn = Integer.MIN_VALUE;
        int pos = 0;
        int[] vis = new int[len];
        for (int i = 0; i < len; i++) {
            vis[i] = cha[i] - 'a';
            if(vis[i] > maxn){
                maxn = vis[i];
                pos = i;
            }
        }

        int count = 0;
        int maxm = Integer.MIN_VALUE;
        int[] result = new int[len];
        for (int i = len - 1; i >= pos; i--) {
            if (vis[i] >= maxm){
                result[count] = cha[i];
                count++;
                maxm = vis[i];
            }
        }

        for (int i = count - 1; i >=0 ; i--) {
            System.out.print((char)(result[i]));
        }

    }
}
