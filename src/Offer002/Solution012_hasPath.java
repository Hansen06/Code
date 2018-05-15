package Offer002;

/**
 * 矩阵中的路径
 */
public class Solution012_hasPath {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || rows < 1 || cols < 1 || str ==null){
            return false;
        }
        boolean[] visited = new boolean[cols*rows];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.println(col);
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (pathLength == str.length){
            return true;
        }
        boolean hasPath = false;
        if (row < rows && col < cols && col >= 0 && row >= 0
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]){
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
            if (!hasPath){
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        System.out.println(hasPath(matrix,3,4,str));
    }
}
