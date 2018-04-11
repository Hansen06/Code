package Exercise;

public class Code_002_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high)/2;
//        int mid = low + ((high - low) >> 1);
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int[] help = new int[high - low + 1];
        int i = 0;
        while (p1 <= mid && p2 <= high) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= high) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[low + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 9, 2, 1};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
