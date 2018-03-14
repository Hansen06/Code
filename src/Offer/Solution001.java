package Offer;

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
