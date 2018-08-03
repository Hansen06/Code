package offer002;

/**
 * 机器人的运动范围
 */
public  class Solution013_movingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 1 || cols < 1){
            return 0;
        }
        int count = 0;
        boolean[] visited = new boolean[rows*cols];
        count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row < rows && col < cols && row >= 0 && col >= 0
                && !visited[row * cols + col]
                && (getSum(row) + getSum(col)) <= threshold){
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution013_movingCount s = new Solution013_movingCount();
        System.out.println(s.movingCount(17, 5,6));
    }
}
