package basic_class_01;

public class Code_04_QuickSort1 {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            System.out.println(p);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    public static int partition(int[] arr, int L, int R) {
        int p = arr[R];
        int less = L - 1;
        for (int i = L; i <= R; i++) {
            if (arr[i] <= p) {
                swap(arr, ++less, i);
            }
        }
        return less;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 5, 7, 6};
//        int index = partition(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        System.out.println(index);

        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }

}
