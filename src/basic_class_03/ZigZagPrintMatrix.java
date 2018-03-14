package basic_class_03;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (row1 != endR + 1) {
            printLevel(matrix, row1, col1, row2, col2, fromUp);
            row1 = col1 == endC ? row1 + 1 : row1; //row1到达最后后往下走
            col1 = col1 == endC ? col1 : col1 + 1; //col1到达最后后不变
            col2 = row2 == endR ? col2 + 1 : col2;
            row2 = row2 == endR ? row2 : row2 + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int row1, int col1, int row2, int col2,
                                  boolean f) {
        if (f) {
            while (row1 != row2 + 1) {
                System.out.print(m[row1++][col1--] + " ");
            }
        } else {
            while (row2 != row1 - 1) {
                System.out.print(m[row2--][col2++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }

}

