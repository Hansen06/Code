package Offer001;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */

public class Solution021_FindNumsAppearOnce {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array == null || array.length < 2){
            return;
        }
        int size = 10000000;
        int[] help = new int[size];
        for (int i = 0; i < array.length; i++) {
            help[array[i]]++;
        }

        int[] result = new int[2];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (help[array[i]] == 1){
                result[k++] = array[i];
            }
        }
        num1[0] = result[0];
        num2[0] = result[1];
    }

    public static void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2){
            return;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }

        int index = 0;
        while((result&1) == 0){
            result = result >> 1;
            index++;
        }

        for (int i = 0; i < array.length; i++) {
            if (((array[i] >> index) & 1) == 1){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce1(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
