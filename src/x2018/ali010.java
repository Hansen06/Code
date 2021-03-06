package x2018;
/**
 * singer_周杰|周杰伦|刘德华|王力宏;song_冰雨|北京欢迎你|七里香;actor_周杰伦|孙俪
 * 请播放周杰伦的七里香给我听
 */

import java.util.Arrays;
import java.util.Scanner;

public class ali010 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] road = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col;j++) {
                road[i][j] = in.nextInt();
            }
        }

        int[][] result = new int[row][col];//用来存储结果，初始化为最大值
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                result[i][j] = findMinPath(road,n,m,i,j);
                result[j][i] = result[i][j];
            }
        }

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int findMinPath(int[][] road, int n, int m, int i, int j) {
        if (m == 1){
            return road[i][j];
        }
        int[] len = new int[n];
        for (int k = 0; k < n; k++) {
            if (k != i && k != j){
                len[k] = findMinPath(road, n, m - 1, k, j) + road[i][k];
            }
        }
        Arrays.sort(len);
        int minPath = Integer.MIN_VALUE;
        for (int k = n-1; k >= 0; k--) {
            if (len[k] != 0){
                minPath =  len[k];
            }
        }
        return minPath;
    }

}
