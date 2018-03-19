package Offer;

import java.util.ArrayList;

/**
 *
 */
public class Solution013_printMatrix {


    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int col = matrix[0].length ;
        int row = matrix.length;

        if (col <= 0 || row <= 0){
            return null;
        }
        if (row == 1){
            for (int i = 0; i < col; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (col == 1){
            for (int i = 0; i < row; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

//        if (row == 1 && col == 1){
//            list.add(matrix[0][0]);
//            return list;
//        }

        int row1 = 0;
        int col1 = 0;
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2){

            int start_row = row1;
            int start_col = col1;
            int end_row = row2;
            int end_col = col2;
            for (int i = start_col; i <= end_col; i++){
                list.add(matrix[start_col][i]);
            }

            if (start_row < end_row){
                for (int i = start_row + 1; i <= end_row; i++) {
                    list.add(matrix[i][end_col]);
                }
            }

            if(start_col < end_col && start_row < end_row){
                for (int i =  end_col - 1; i >= start_col; i--) {
                    list.add(matrix[end_row][i]);
                }
            }
            if (start_col < end_col&& start_row < end_row){
                for (int i = end_row - 1; i > start_row; i--) {
                    list.add(matrix[i][start_col]);
                }
            }
            row1++;
            col1++;
            row2--;
            col2--;
        }
        return list;
    }



    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
//
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(matrix[0][i]);
//        }

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list = printMatrix(matrix);
//        for (int value : list) {
//            System.out.println(value);
//        }
//
//        System.out.println("----------------");
//        int[][] matrix1 = {{1}};
//        System.out.println(matrix1.length);
//        System.out.println(matrix1[0].length);
//
//        System.out.println("------------");
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        list1 = printMatrix(matrix1);
//        for (int value1 : list1) {
//            System.out.println(value1);
//        }
//
//
//        System.out.println("========================");
//        int[][] matrix2 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        list2 = printMatrix(matrix2);
//        for (int value1 : list2) {
//            System.out.println(value1);
//        }
//
//        System.out.println("===============================");
        int[][] matrix3 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15,16}};
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3 = printMatrix(matrix3);
        for (int value1 : list3) {
            System.out.println(value1);
        }
    }
}
