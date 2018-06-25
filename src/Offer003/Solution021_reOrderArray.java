package Offer003;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Solution021_reOrderArray {

    public static void reOrderArray(int [] array) {

        if (array == null || array.length < 1){
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            while (left < right && !isEven(array[left])){
                left++;
            }
            while (left < right && isEven(array[right])){
                right--;
            }

            if (left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }

    public static void reOrderArray1(int [] array) {

        if (array == null || array.length < 1){
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (!isEven(array[j]) && isEven(array[j-1])){
                    swap(array, j, j-1);
                }
            }
        }
    }

    public static boolean isEven(int num){
        return (num & 1) == 0;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        reOrderArray1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
