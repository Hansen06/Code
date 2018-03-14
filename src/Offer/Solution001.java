package Offer;

/**
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Solution001 {

    public boolean Find(int target, int [][] array) {
        int col = array[0].length - 1;
        int row = 0;
        while (row < array.length && col >= 0){
            if(array[row][col] == target){
                return true;
            }else if (array[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {



    }
}
