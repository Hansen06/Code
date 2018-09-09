package samsung;

import java.util.Stack;

public class Solution_20180728_dfs {

    public static int count = 0;
    public static boolean[][] visited;
    public static int index = 0;
    public static void dfs(int[][] matrix, int row, int col, int step, int[][] can_get){
        if (matrix.length < 1 || step < 1 || row < 0 || col < 0){
            return;
        }

        visited[row][col] = true;
        int[] cur_pos = {row, col};
        Stack<int[]> stack = new Stack<>();
        stack.push(cur_pos);
        while (!stack.isEmpty() && step >= 0) {
            count++;
            step--;
            int[] pos = stack.pop();
            int cur_row = pos[0];
            int cur_col = pos[1];

            int cur_num = matrix[cur_row][cur_col];
            int[] can = can_get[cur_num - 1];

            //判断左侧
            if (cur_col - 1 >= 0 && matrix[cur_row][cur_col - 1] != 0) {
                int left_num = matrix[cur_row][cur_col - 1];
                if (can_get[left_num - 1][3] == 1 && can[2] == 1) {
                    if (!visited[cur_row][cur_col - 1]) {
                        visited[cur_row][cur_col - 1] = true;
                        int[] p = {cur_row, cur_col - 1};
                        stack.push(p);
                    }
                }
            }
            //判断上方
            if (cur_row - 1 >= 0 && matrix[cur_row - 1][cur_col] != 0) {
                int top_num = matrix[cur_row - 1][cur_col];
                if (can_get[top_num - 1][1] == 1 && can[0] == 1) {
                    if (!visited[cur_row - 1][cur_col]) {
                        visited[cur_row - 1][cur_col] = true;
                        int[] p = {cur_row - 1, cur_col};
                        stack.push(p);
                    }
                }
            }

            //判断右侧
            if (cur_col + 1 < matrix[0].length && matrix[cur_row][cur_col + 1] != 0) {
                int right_num = matrix[cur_row][cur_col + 1];
                if (can_get[right_num - 1][2] == 1 && can[3] == 1) {
                    if (!visited[cur_row][cur_col + 1]) {
                        visited[cur_row][cur_col + 1] = true;
                        int[] p = {cur_row, cur_col + 1};
                        stack.push(p);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int step = 3;
        int start_row = 2;
        int start_col = 1;
        int[][] matrix = { {0,0,5,3,6,0},
                           {0,0,2,0,2,0},
                           {3,3,1,3,7,0},
                           {0,0,0,0,0,0},
                           {0,0,0,0,0,0}
                        };
        int[][] can_get = { {1,1,1,1},
                            {1,1,-1,-1},
                            {-1,-1,1,1},
                            {1,-1,-1,1},
                            {-1,1,-1,1},
                            {-1,1,1,-1},
                            {1,-1,1,-1}
                          };
        visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, start_row, start_col, step, can_get);
        System.out.println(count);
    }

}
