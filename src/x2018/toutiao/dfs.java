package x2018.toutiao;

import java.util.LinkedList;
import java.util.Queue;

public class dfs {

    public static boolean[][] visited;

    public static void bfs(int[][] matrix, int row, int col) {
        if (matrix.length < 1 || row < 0 || col < 0) {
            return;
        }

        visited[row][col] = true;

        //判断左侧
        if (col - 1 >= 0 && matrix[row][col - 1] != 0) {
            int left_num = matrix[row][col - 1];
            if (!visited[row][col - 1] && left_num == 1) {
                visited[row][col - 1] = true;
                bfs(matrix, row, col - 1);
            }
        }
        //判断上方
        if (row - 1 >= 0 && matrix[row - 1][col] != 0) {
            int top_num = matrix[row - 1][col];
            if (!visited[row - 1][col] && top_num == 1) {
                visited[row - 1][col] = true;
                bfs(matrix, row - 1, col);
            }
        }

        //判断右侧
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != 0) {
            int right_num = matrix[row][col + 1];
            if (!visited[row][col + 1] && right_num == 1) {
                visited[row][col + 1] = true;
                bfs(matrix, row, col + 1);
            }
        }

        //判断下方
        if (row + 1 < matrix.length && matrix[row + 1][col] != 0) {
            int down_num = matrix[row + 1][col];
            if (!visited[row + 1][col] && down_num == 1) {
                visited[row + 1][col] = true;
                bfs(matrix, row + 1, col);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        int[][] matrix = {{1, 0, 0, 1, 1},
                          {1, 0, 0, 1, 1},
                          {0, 0, 1, 0, 0},
                          {0, 0, 1, 0, 0},
                          {0, 0, 1, 0, 0}
        };
        int count = 0;
        visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    count++;
                    bfs(matrix, i, j);
                }
            }
        }

        System.out.println(count);
    }

}
