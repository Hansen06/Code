package x2018.meituan;

import java.util.ArrayList;
import java.util.Scanner;

public class meituan001{

    public static class Node{
        int val;
        public ArrayList<Node> nexts;
        public Node(int value){
            this.val = value;
            nexts = new ArrayList<>();
        }
    }

    public static int ans = 0;
    public static void dfs(int[][] matrix, int next, int height){
        for (int i = 0; i < matrix.length; i++) {

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }

        dfs(matrix,1, -1);
        System.out.println(2*(n-1)-ans);

    }
}
