package samsang;

public class Solution_20180728 {

    public static int count = 0;
    public static int[][] contain;
    public static int index = 0;
    public static void dfs(int[][] matrix, int start_row, int start_col, int step, int[][] can_get){
        if (matrix.length < 1 || step < 1 || start_row < 0 || start_col < 0){
            return;
        }
        if (step == 0){
            return;
        }
        step--;
        count++;
        int[] cur_pos = new int[2];
        cur_pos[0] = start_row;
        cur_pos[1] = start_col;
        contain[index] = cur_pos;
        index++;
        int cur_num = matrix[start_row][start_col];
        int[] can = can_get[cur_num - 1];
        System.out.println(String.valueOf(start_row) + "|" + String.valueOf(start_col));

        //判断左侧
        if (start_col - 1 >= 0 && matrix[start_row][start_col-1] != 0){
            int left_num = matrix[start_row][start_col - 1];
            if (can_get[left_num-1][3] == 1 && can[2] == 1){
                boolean flag = false;
                for (int i = 0; i < index; i++) {
                    if (contain[i][0] == start_row && contain[i][1] == start_col - 1){
                        flag = true;
                    }
                }
                if (!flag) {
                    dfs(matrix, start_row, start_col - 1, step, can_get);
                }
            }
        }
        //判断上方
        if (start_row - 1 >= 0 && matrix[start_row-1][start_col] != 0){
            int top_num = matrix[start_row-1][start_col];
            if (can_get[top_num-1][1] == 1 && can[0] == 1) {
                boolean flag = false;
                for (int i = 0; i < index; i++) {
                    if (contain[i][0] == start_row - 1 && contain[i][1] == start_col) {
                        flag = true;
                    }
                }
                if (!flag) {
                    dfs(matrix, start_row - 1, start_col, step, can_get);
                }
            }
        }

        //判断右侧
        if (start_col + 1 < matrix[0].length && matrix[start_row][start_col + 1] != 0){
            int right_num = matrix[start_row][start_col+1];
            if (can_get[right_num-1][2] == 1 && can[3] == 1) {
                boolean flag = false;
                for (int i = 0; i < index; i++) {
                    if (contain[i][0] == start_row && contain[i][1] == start_col + 1) {
                        flag = true;
                    }
                }
                if (!flag) {
                    dfs(matrix, start_row, start_col + 1, step, can_get);
                }
            }
        }

        //判断下方
        if (start_row + 1 < matrix.length && matrix[start_row + 1][start_col] != 0){
            int down_num = matrix[start_row + 1][start_col];
            if (can_get[down_num-1][0] == 1 && can[1] == 1) {
                boolean flag = false;
                for (int i = 0; i < index; i++) {
                    if (contain[i][0] == start_row + 1 && contain[i][1] == start_col) {
                        flag = true;
                    }
                }
                if (!flag) {
                    dfs(matrix, start_row + 1, start_col, step, can_get);
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
        contain = new int[5*6][2];
        dfs(matrix, start_row, start_col, step, can_get);
        System.out.println(count);
    }

}
