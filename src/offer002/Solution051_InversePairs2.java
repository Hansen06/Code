package offer002;

/**
 * 数组中的逆序对
 */
public class Solution051_InversePairs2 {


    public int InversePairs(int [] array) {
        if (array == null || array.length < 2){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high){
            copy[low] = array[low];
            return 0;
        }

        int mid = (low + high) / 2;
        int left = InversePairsCore(copy, array, low, mid) % 1000000007; // 第一个参数为copy 防止改变原数据
        int righ = InversePairsCore(copy, array, mid + 1, high) % 1000000007;

        int count = 0;
        int i = mid;
        int j = high;
        int index = high;
        while (i >= low && j >= mid + 1){
            if (array[i] > array[j]){
                copy[index--] = array[i--];
                count += j - mid;
                if (count >= 1000000007){
                    count %= 1000000007;
                }
            }else {
                copy[index--] = array[j--];
            }
        }

        for (;  i >= low ; i--) {
            copy[index--] = array[i];
        }
        for (;  j >= mid + 1 ; j--) {
            copy[index--] = array[j];
        }
        return (left+righ+count) % 1000000007;
    }


    public static void main(String[] args) {

        Solution051_InversePairs2 inversePairs1 = new Solution051_InversePairs2();
        int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr1 = {7,5,6,4};
        int[] arr2 = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
//        System.out.println(inversePairs1.InversePairs(arr_360003));
        System.out.println(inversePairs1.InversePairs(arr1));
        System.out.println();
        for (int num : arr1) {
            System.out.println(num);
        }
    }
}
