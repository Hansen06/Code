package offer002;

public class Solution047_getMaxValue {

    public static int getMaxValue(int[] matrix, int rows, int cols){
        if (matrix == null || rows < 1 || cols < 1){
            return 0;
        }

        int[][] maxValue = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i*cols+j] + " ");
                int left = 0;
                int up = 0;
                if (i > 0){
                    up = maxValue[i-1][j];
                }
                if (j > 0){
                    left = maxValue[i][j-1];
                }

                maxValue[i][j] = (up > left ? up :left) + matrix[i*cols+j];
            }
        }
        return maxValue[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[] matrix = {1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
        System.out.println(getMaxValue(matrix,4,4));

        int up = 10;
        int left = 9;
        System.out.println(up > left ? up :left);
    }
}
