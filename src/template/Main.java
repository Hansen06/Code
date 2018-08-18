package template;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

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

        int[] s = new int[m+2];
        s[0]=n;
        solve(n,m,1,n,s,road,result);

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void solve(int n,int m,int t,int root,int[] s,int[][] map,int[][] res){
        if(t==(m+2)) {
            int sum=0;
            for(int j=1;j<s.length-1;j++) {
                sum += map[s[j]][s[j+1]];
            }
            if(sum<res[s[1]][s[m+1]])
                res[s[1]][s[m+1]] = sum;
        }
        else {
            int[] arr = find(n,root);
            for(int i=0;i<arr.length;i++) {
                s[t] = arr[i];
                solve(n,m,t+1,arr[i],s,map,res);
            }
        }
    }

    public static int[] find(int n,int root) {
        int[] arr;
        if(root==n) {
            arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = i;
            }
        }
        else {
            arr = new int[n-1];
            int t = 0;
            for(int i=0;i<n;i++) {
                if(i==root) continue;
                arr[t] = i;
                t++;
            }
        }
        return arr;
    }

}
