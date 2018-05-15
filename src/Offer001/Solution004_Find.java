package Offer001;

/**
 * 二维数组中的查找
 */

public class Solution004_Find {

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
