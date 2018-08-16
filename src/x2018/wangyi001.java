package x2018;

import java.util.Scanner;

/**
 * 网易校招
 */
public class wangyi001 {

    public static void binarySearch(int[] arr,int key,int low,int high, int[] pos) {

        if (low > high) {
            return;
        }

        int middle = (low + high) / 2;  //初始中间位置
        if (arr[middle] >= key) {
            pos[1] = middle;
            binarySearch(arr, key, low, middle - 1, pos);
        } else if (arr[middle] < key) {
            pos[0] = middle;
            binarySearch(arr, key, middle + 1, high, pos);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] all = new int[n];
        for(int i = 0; i < n; i++){
            if (i > 0){
               all[i] = sc.nextInt() + all[i-1];
            }else {
                all[i] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int[] pos = new int[2];
            binarySearch(all, x, 0, all.length-1, pos);
//            System.out.println(pos[0] + " " + pos[1]);
            for (int j = pos[0]; j <= pos[1]; j++) {
                if (all[j] >= x){
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
