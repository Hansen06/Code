package x2018;

import java.util.*;


public class yitu02 {


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] arr = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//
//        }
        int[][] arr1 = {{0,0,0,0},{1,0,0,1},{1,1,1,0}};

        System.out.println(maxAreaOfIsland(arr1));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1){
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> list_size = new ArrayList<Integer>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                visited[row][col] = true;
                if (grid[row][col] == 1){
                    queue.add(new int[]{row,col});
                }
                int cur_size = 0;
                while (!queue.isEmpty()){
                    cur_size++;
                    int[] cur = queue.poll();
                    int r = cur[0];
                    int c = cur[1];
                    if (c -1 >= 0 && !visited[r][c-1] && grid[r][c - 1] == 1){
                        queue.add(new int[]{r, c - 1});
                        visited[r][c-1] = true;
                    }
                    if (r -1 >= 0 && !visited[r-1][c] && grid[r-1][c] == 1){
                        queue.add(new int[]{r-1,c});
                        visited[r-1][c] = true;
                    }
                    if (c + 1 < grid[0].length && !visited[r][c+1] && grid[r][c+1] == 1){
                        queue.add(new int[]{r, c+1});
                        visited[r][c+1] = true;
                    }
                    if (r + 1 < grid.length && !visited[r+1][c] && grid[r+1][c] == 1){
                        visited[r+1][c] = true;
                        queue.add(new int[]{r+1, c});
                    }
                }
                list_size.add(cur_size);
            }
        }
        int max_size = 0;
        for (int i = 0; i < list_size.size(); i++) {
            if (list_size.get(i) > max_size){
                max_size = list_size.get(i);
            }
        }
        return max_size;
    }
}
