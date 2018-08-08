package leetcode_depth_first_search;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Flood Fill
 */
public class Solution0733_FloodFill {

    /**
     * bfs
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length < 0 || image[0].length < 0 || sr < 0 || sc < 0 || sr > image.length || sc > image[0].length){
            return null;
        }

        int image_width = image[0].length;
        int image_height = image.length;
        int start_num = image[sr][sc];
        image[sr][sc] = newColor;
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while (!queue.isEmpty()){
            int[] tmp_pos = queue.poll();
            int tmp_row = tmp_pos[0];
            int tmp_col = tmp_pos[1];
            if (tmp_col-1 >= 0 && !visited[tmp_row][tmp_col-1] && image[tmp_row][tmp_col-1] == start_num){
                queue.add(new int[]{tmp_row,tmp_col-1});
                image[tmp_row][tmp_col-1] = newColor;
                visited[tmp_row][tmp_col-1] = true;
            }
            if (tmp_row-1 >= 0 && !visited[tmp_row-1][tmp_col] && image[tmp_row-1][tmp_col] == start_num){
                queue.add(new int[]{tmp_row-1,tmp_col});
                image[tmp_row-1][tmp_col] = newColor;
                visited[tmp_row-1][tmp_col] = true;
            }
            if (tmp_col + 1 < image_width && !visited[tmp_row][tmp_col+1] && image[tmp_row][tmp_col+1] == start_num){
                queue.add(new int[]{tmp_row,tmp_col+1});
                image[tmp_row][tmp_col+1] = newColor;
                visited[tmp_row][tmp_col+1] = true;
            }
            if (tmp_row + 1 < image_height && !visited[tmp_row+1][tmp_col] && image[tmp_row+1][tmp_col] == start_num){
                queue.add(new int[]{tmp_row+1,tmp_col});
                image[tmp_row+1][tmp_col] = newColor;
                visited[tmp_row+1][tmp_col] = true;
            }
        }

        return image;
    }

    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, color, newColor);
        dfs(image, sr - 1, sc, color, newColor);
        dfs(image, sr, sc - 1, color, newColor);
        dfs(image, sr, sc + 1, color, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill1(image,1,1,2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}
