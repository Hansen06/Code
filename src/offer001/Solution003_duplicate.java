package offer001;

/**
 * 数组中重复的数字
 */

public class Solution003_duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return val:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false


    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if (length == 0){
            return false;
        }

        //边界值的检测
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length-1){
                return false;
            }
        }
//        int  max = 0;
//        for (int i = 0; i < length; i++) {
//            if (numbers[i] > max){
//                max = numbers[i];
//            }
//        }
        int[] help = new int[length];

        for (int i = 0; i < length; i++) {
            help[numbers[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if (help[i] > 1){
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    public static boolean duplicate1(int numbers[],int length,int [] duplication) {

        if (length == 0){
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    int tem = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = tem;
                }
            }
        }
        return false;
    }

    /**
     * 不修改数组实现查重
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {

        if (length == 0){
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }

        int start = 1;
        int end = length - 1;
        while (start <= end){
            int mid = ((end - start) >>1) + start;
            int count = findDup(numbers, length, start, mid);
            if (end == start){
                if (count > 1){
                   duplication[0] = start;
                   return true;
                }else{
                    break;
                }
            }
            if (count > (mid - start + 1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    public static int findDup(int[] numbers, int length, int start, int mid) {

        if (numbers == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length ; i++) {
            if(numbers[i] >= start && numbers[i] <= mid){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,1,1,2,5,3};
        int[] dup = new int[10];

        System.out.println(duplicate1(arr, arr.length, dup));
        System.out.println(duplicate2(arr, arr.length, dup));
        System.out.println(dup[0]);

    }
}
