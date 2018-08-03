package leetcode_depth_first_search;

import java.util.*;

/**
 *  Max Area of Island
 */
public class Solution0695_MaxAreaofIsland_bfs {


    /**
     *bfs
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1){
            return 0;
        }
        HashSet<int[]> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> list_size = new ArrayList<Integer>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                for (int[] arr: set) {
                    if (arr[0] == row && arr[1] == col){
                        break;
                    }
                }
                set.add(new int[]{row,col});
                if (grid[row][col] == 1){
                    queue.add(new int[]{row,col});
                }
                int cur_size = 0;
                while (!queue.isEmpty()){
                    cur_size++;
                    int[] cur = queue.poll();
                    int r = cur[0];
                    int c = cur[1];
                    if (c -1 >= 0){
                        boolean flag = false;
                        for (int[] arr: set) {
                            if (arr[0] == r && arr[1] == c-1){
                                flag = true;
                            }
                        }
                        if (!flag) {
                            set.add(new int[]{r,c-1});
                            if (grid[r][c - 1] == 1) {
                                queue.add(new int[]{r, c - 1});
                            }
                        }
                    }
                    if (r -1 >= 0){
                        boolean flag = false;
                        for (int[] arr: set) {
                            if (arr[0] == r-1 && arr[1] == c){
                                flag = true;
                            }
                        }
                        if (!flag) {
                            set.add(new int[]{r-1,c});
                            if (grid[r-1][c] == 1){
                                queue.add(new int[]{r-1,c});
                            }
                        }
                    }
                    if (c + 1 < grid[0].length){
                        boolean flag = false;
                        for (int[] arr: set) {
                            if (arr[0] == r && arr[1] == c+1){
                                flag = true;
                            }
                        }
                        if (!flag) {
                            set.add(new int[]{r, c+1});
                            if (grid[r][c+1] == 1){
                                queue.add(new int[]{r, c+1});
                            }
                        }
                    }
                    if (r + 1 < grid.length ){
                        boolean flag = false;
                        for (int[] arr: set) {
                            if (arr[0] == r+1 && arr[1] == c){
                                flag = true;
                            }
                        }
                        if (!flag) {
                            set.add(new int[]{r+1, c});
                            if (grid[r+1][c] == 1){
                                queue.add(new int[]{r+1, c});
                            }
                        }
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

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
        HashSet<int[]> set = new HashSet<>();

        set.add(new int[]{0,1});
        if (set.contains(new int[]{0,1})){
            System.out.println("asdfds");
        }


    }

}
