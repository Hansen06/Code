package Offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class Solution026_MoreThanHalfNum {

    public static int MoreThanHalfNum_Solution(int [] array) {

        Integer result = 0;
        if (array == null){
            return result;
        }
        int[] help = new int[10000000];
        for (int i = 0; i < array.length; i++) {
            help[array[i]]++;
        }

        for (int i = 0; i < help.length; i++) {
            if (help[i] > array.length/2){
                result = i;
            }
        }
        return result;
    }
    public static int MoreThanHalfNum_Solution1(int [] array) {

        Integer result = 0;
        if (array == null){
            return result;
        }

        result = array[0];
        int time = 1;

        for (int i = 1; i < array.length; i++) {
            if (time == 0){
                result = array[i];
                time = 1;
            }else if(array[i] == result){
                time++;
            }else {
                time--;
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result){
                num++;
            }
        }
        if (num <= array.length/2){
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,4,1,4,2};
        System.out.println(MoreThanHalfNum_Solution1(arr));
    }

}
