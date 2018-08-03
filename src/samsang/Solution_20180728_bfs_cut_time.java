package samsang;

public class Solution_20180728_bfs_cut_time {

    public static int count = 0;
    public static boolean[][] visited;
    public static int index = 0;
    public static void dfs(int[][] matrix, int row, int col, int step, int[][] can_get){
        if (matrix.length < 1 || step < 1 || row < 0 || col < 0){
            return;
        }
        if (step == 0){
            return;
        }
        step--;
        count++;
        visited[row][col] = true;
        int cur_num = matrix[row][col];
        int[] can = can_get[cur_num - 1];

        //判断左侧
        if (col - 1 >= 0 && matrix[row][col-1] != 0){
            int left_num = matrix[row][col - 1];
            if (can_get[left_num-1][3] == 1 && can[2] == 1){
                if (!visited[row][col-1]){
                    visited[row][col-1] = true;
                    dfs(matrix, row, col - 1, step, can_get);
                }
            }
        }
        //判断上方
        if (row - 1 >= 0 && matrix[row-1][col] != 0){
            int top_num = matrix[row-1][col];
            if (can_get[top_num-1][1] == 1 && can[0] == 1) {
                if (!visited[row-1][col]){
                    visited[row-1][col] = true;
                    dfs(matrix, row - 1, col, step, can_get);
                }
            }
        }

        //判断右侧
        if (col + 1 < matrix[0].length && matrix[row][col + 1] != 0){
            int right_num = matrix[row][col+1];
            if (can_get[right_num-1][2] == 1 && can[3] == 1) {
                if (!visited[row][col+1]){
                    visited[row][col+1] = true;
                    dfs(matrix, row, col + 1, step, can_get);
                }
            }
        }

        //判断下方
        if (row + 1 < matrix.length && matrix[row + 1][col] != 0){
            int down_num = matrix[row + 1][col];
            if (can_get[down_num-1][0] == 1 && can[1] == 1) {
                if (!visited[row+1][col]){
                    visited[row+1][col] = true;
                    dfs(matrix, row + 1, col, step, can_get);
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
