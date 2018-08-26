package newcoder;

/**
 * 输出数组的全排列
 */
public class FullPermutation {


    public static void perm(int[] arr, int k, int m){
        if (k == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = k; i < m; i++) {
            swap(arr, k, i);
            perm(arr, k + 1, m);
            swap(arr, k, i);
        }
    }

    public static void swap(int[] arr, int k, int i){
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        perm(arr,0, arr.length);
    }

}
