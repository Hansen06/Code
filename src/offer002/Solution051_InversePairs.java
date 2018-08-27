package offer002;

/**
 * 数组中的逆序对
 */
public class Solution051_InversePairs {

    public static int num = 0;
    public static int InversePairs(int [] array) {
        if (array == null || array.length < 2){
            return 0;
        }
        MergeSort(array, 0, array.length - 1);
        return num;
    }


    public static void MergeSort(int[] arr, int low, int high){
        if (low == high){
            return ;
        }
        int mid = ((high - low)>>1) + low;
        MergeSort(arr, low, mid);
        MergeSort(arr, mid + 1, high);
        num += Merge(arr, low, mid, high);
    }

    private static int Merge(int[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int[] help = new int[high - low + 1];
        int i = 0;
        int count = 0;
        while (p1 <= mid && p2 <= high){
            if (arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else{
                help[i++] = arr[p2++];
                count += mid - p1 + 1;
            }
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= high){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[low + j] = help[j];
        }
//        System.out.println("merge:" + " " + count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr1 = {7,5,6,4};
//        System.out.println(InversePairs(arr_360003));
        System.out.println(InversePairs(arr1));
        System.out.println();
        for (int num : arr1) {
            System.out.println(num);
        }
    }
}
