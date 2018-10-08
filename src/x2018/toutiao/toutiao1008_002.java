package x2018.toutiao;

import java.util.Scanner;

public class toutiao1008_002 {

    public static boolean[][] visited;
    public static boolean[][] change;

    public static void dfs(int[][] matrix, int row, int col, int step) {
        if (matrix.length < 1 || step < 0 || row < 0 || col < 0) {
            return;
        }
        if (step == 0) {
            return;
        }
        step--;
        visited[row][col] = true;
        change[row][col] = true;

        //判断左侧
        if (col - 1 >= 0 && matrix[row][col - 1] != -1) {
            if (!visited[row][col - 1]) {
                visited[row][col - 1] = true;
                change[row][col - 1] = true;
                dfs(matrix, row, col - 1, step);
            }
        }
        //判断上方
        if (row - 1 >= 0 && matrix[row - 1][col] != -1) {
            if (!visited[row - 1][col]) {
                visited[row - 1][col] = true;
                change[row - 1][col] = true;
                dfs(matrix, row - 1, col, step);
            }
        }

        //判断右侧
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != -1) {
            if (!visited[row][col + 1]) {
                visited[row][col + 1] = true;
                change[row][col + 1] = true;
                dfs(matrix, row, col + 1, step);
            }
        }

        //判断下方
        if (row + 1 < matrix.length && matrix[row + 1][col] != -1) {
            if (!visited[row + 1][col]) {
                visited[row + 1][col] = true;
                change[row + 1][col] = true;
                dfs(matrix, row + 1, col, step);
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int k = sc.nextInt();
//        String str_a = String.valueOf(k);
//        System.out.println(String.valueOf(a));
        int step = 3;
        int[][] matrix = {{0, -1, 1, 0},
                {0, 0, 0, -1},
                {0, -1, 0, -1},
                {1, -1, 0, 0},
        };
        visited = new boolean[matrix.length][matrix[0].length];
        change = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j, step);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (change[i][j] || matrix[i][j] == -1) {
                    matrix[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(change[i][j] + " ");
            }
            System.out.println();
        }
    }
}
