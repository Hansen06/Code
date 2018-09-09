package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Max Area of Island
 */
public class Solution0695_MaxAreaofIsland_dfs {


    /**
     *bfs
     */
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1){
            return 0;
        }
        int max_area = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1){
                    max_area = Math.max(max_area,dfs(grid, row, col));
                }
            }
        }
        return max_area;
    }

    private static int dfs(int[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == 1){
            grid[row][col] = 0;
            return 1 + dfs(grid, row, col-1) + dfs(grid, row-1,col) + dfs(grid,row, col + 1) + dfs(grid, row + 1, col);
        }
        return 0;
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
