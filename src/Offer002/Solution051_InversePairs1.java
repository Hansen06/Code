package Offer002;

/**
 * 数组中的逆序对
 */
public class Solution051_InversePairs1 {

    public int count = 0;
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2){
            return 0;
        }
        MergeSort(array, 0, array.length - 1);
        return count;
    }


    public void MergeSort(int[] arr, int low, int high){
        if (low == high){
            return ;
        }
        int mid = ((high - low)>>1) + low;
        MergeSort(arr, low, mid);
        MergeSort(arr, mid + 1, high);
        Merge(arr, low, mid, high);
    }

    private void Merge(int[] arr, int low, int mid, int high) {
        int p1 = low;
        int p2 = mid + 1;
        int[] help = new int[high - low + 1];
        int i = 0;
        while (p1 <= mid && p2 <= high){
            if (arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else{
//                count += p2 - mid;//核心 方法错误 如 5 7    4 5
                help[i++] = arr[p2++];
                count += mid - p1 + 1;//核心
                if(count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
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
    }

    public static void main(String[] args) {

        Solution051_InversePairs1 inversePairs1 = new Solution051_InversePairs1();
        int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr1 = {7,5,6,4};
        int[] arr2 = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
//        System.out.println(inversePairs1.InversePairs(arr));
        System.out.println(inversePairs1.InversePairs(arr2));
        System.out.println();
        for (int num : arr2) {
            System.out.println(num);
        }
    }
}
