package offer002;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class Solution045_PrintMinNumber {


    private int a  = 0;
    public static void quickSort(char[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(char[] arr, int low, int high){
        while (low < high){
            int[] p = partition(arr, low, high);
            quickSort(arr, 0, p[0]-1);
            quickSort(arr, p[1]+1, high);
        }
    }

    private static int[] partition(char[] arr, int low, int high) {
        int less = low - 1;
        int more = high;
        while (low < more){
            if (arr[low] < arr[high]){
                swap(arr, ++less, low++);
            }else if(arr[low] > arr[high]){
                swap(arr, --more, low);
            }{
                low++;
            }
        }
        swap(arr, more, high);
        return new int[]{less + 1, more};
    }

    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static String PrintMinNumber(int [] numbers) {

        if (numbers == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String tmp1 = s1 + s2;
                String tmp2 = s2 + s1;

                System.out.println("temp1: " + tmp1);
                System.out.println("temp2: " + tmp2);
                System.out.println(tmp1.compareTo(tmp2));
                return tmp1.compareTo(tmp2);
            }
        });

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));

    }
}