package x2018;

import java.util.Scanner;

/**
 * 网易校招
 */
public class wangyi002 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ex = new int[n];
        int[] wk = new int[n];
        for(int i = 0; i < n; i++){
           ex[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
           wk[i] = sc.nextInt();
        }
        int sum = 0;
        int i = 0;
        while (i <= n-1){
            if (wk[i] != 0){
                sum += ex[i];
            }
            i++;
            if (wk[i] == 0 && k != 0){
                k--;
                if (sum < ex[i]){
                    sum = ex[i];
                    for (int j = 1; j < 3; j++) {
                        if (j + i < n){
                            sum += ex[j + i];
                        }
                    }
                }else{
                    sum += ex[i];
                }
                i += 2;
            }
        }
        System.out.println(sum);
    }
}
