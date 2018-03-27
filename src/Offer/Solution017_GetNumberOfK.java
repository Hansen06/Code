package Offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution017_GetNumberOfK {

    public static int GetNumberOfK(int [] array , int k) {

        int len = array.length;
        if (len <= 0){
            return 0;
        }
        if (k > array[len-1] || k < array[0]){
            return 0;
        }

        int[] map = helpMap(array,len);
        return map[k];
    }

    public static int[] helpMap(int[] array, int len){

        int max = array[len-1];
        int[] map = new int[max + 1];
        for (int i = 0; i < len; i++) {
            map[array[i]]++;
        }
        return map;
    }

    public static int GetNumberOfK1(int [] array , int k) {

        int len = array.length;
        if (len <= 0){
            return 0;
        }
        if (k > array[len-1] || k < array[0]){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == k){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,2,2,3,4,5,6,6};
        System.out.println(GetNumberOfK(arr,2));
        System.out.println(GetNumberOfK(arr,3));
        System.out.println(GetNumberOfK(arr,6));
        System.out.println(GetNumberOfK(arr,7));
        System.out.println(GetNumberOfK(arr,-1));
    }
}
