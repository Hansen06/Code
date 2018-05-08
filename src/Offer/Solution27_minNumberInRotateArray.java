package Offer;

/**
 * 旋转数组的最小数字
 */
public class Solution27_minNumberInRotateArray {

    public static int minNumberInRotateArray2(int[] array) {

        if (array == null) {
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2){
                    return array[0];
                }
            }
        }
        return 0;
    }

    public static int minNumberInRotateArray(int[] array) {
        Integer result = null;
        if (array == null) {
            return result;
        }

        if (array[0] < array[array.length - 1]) {
            result = array[0];
        } else {
            int flag = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] >= flag) {
                    flag = array[i];
                } else {
                    result = array[i];
                    break;
                }
            }
        }
        return result;
    }

    public static int minNumberInRotateArray1(int[] array) {
        Integer result = null;
        if (array == null) {
            return result;
        }

        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;

        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }

            mid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[mid] == array[index1]) {
                return getMin1(array, index1, index2);
            }

            if (array[mid] >= array[index1]) {
                index1 = mid;
            } else if (array[mid] <= array[index2]) {
                index2 = mid;
            }
        }

        result = array[mid];
        return result;
    }

    private static int getMin(int[] array, int index1, int index2) {
        int result = 0;
        int flag = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (array[i] >= flag) {
                flag = array[i];
            } else {
                result = array[i];
                break;
            }
        }
        return result;
    }

    private static int getMin1(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 2, 2};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(minNumberInRotateArray1(arr));
        System.out.println(minNumberInRotateArray2(arr));
    }
}
