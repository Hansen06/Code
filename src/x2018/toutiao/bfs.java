package x2018.toutiao;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    public static boolean[][] visited;
    public static void bfs(int[][] matrix, int row, int col) {
        if (matrix.length < 1 || row < 0 || col < 0) {
            return;
        }

        visited[row][col] = true;
        int[] pos = {row, col};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_row = cur[0];
            int cur_col = cur[1];
            //判断左侧
            if (cur_col - 1 >= 0 && matrix[cur_row][cur_col - 1] != 0) {
                int left_num = matrix[cur_row][cur_col - 1];
                if (!visited[cur_row][cur_col - 1] && left_num == 1) {
                    visited[cur_row][cur_col - 1] = true;
                    int[] p = {cur_row, cur_col - 1};
                    queue.add(p);
                }
            }
            //判断上方
            if (cur_row - 1 >= 0 && matrix[cur_row - 1][cur_col] != 0) {
                int top_num = matrix[cur_row - 1][cur_col];
                if (!visited[cur_row - 1][cur_col] && top_num == 1) {
                    visited[cur_row - 1][cur_col] = true;
                    int[] p = {cur_row - 1, cur_col};
                    queue.add(p);
                }
            }

            //判断右侧
            if (cur_col + 1 < matrix[0].length && matrix[cur_row][cur_col + 1] != 0) {
                int right_num = matrix[cur_row][cur_col + 1];
                if (!visited[cur_row][cur_col + 1] && right_num == 1) {
                    visited[cur_row][cur_col + 1] = true;
                    int[] p = {cur_row, cur_col + 1};
                    queue.add(p);
                }
            }

            //判断下方
            if (cur_row + 1 < matrix.length && matrix[cur_row + 1][cur_col] != 0) {
                int down_num = matrix[cur_row + 1][cur_col];
                if (!visited[cur_row + 1][cur_col] && down_num == 1) {
                    visited[cur_row + 1][cur_col] = true;
                    int[] p = {cur_row + 1, cur_col};
                    queue.add(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 1},
                            {0, 0, 0, 0}
                          };
        int[][] matrix1 = {  {1, 0, 0, 1, 1},
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
