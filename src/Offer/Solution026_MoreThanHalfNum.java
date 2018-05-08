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

    public static int MoreThanHalfNum_Solution2(int [] array) {

        Integer result = 0;
        if (array == null){
            return result;
        }

        int mid = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = Partition(array, start, end);
        while(index != mid){
            if (index > mid){
                end = index - 1;
                index = Partition(array, start, end);
            }else{
                start = index + 1;
                index = Partition(array, start, end);
            }
        }
        result = array[mid];

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

    public static int Partition(int[] data, int start, int end){

        int p = data[end];
        int less = start - 1;
        for ( int i = start; i < end; i++){
            if (data[i] <= p ) {
                swap(data, ++less, i);
            }
        }
        ++less;
        swap(data, less, end);
        return less;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,4,1,4,2};
        System.out.println(MoreThanHalfNum_Solution1(arr));
        System.out.println(MoreThanHalfNum_Solution2(arr));
    }

}
