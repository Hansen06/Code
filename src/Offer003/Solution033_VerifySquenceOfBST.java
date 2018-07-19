package Offer003;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Solution033_VerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1){
            return false;
        }
        if (sequence.length == 1){
            return true;
        }

        return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    private static boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {

        if (start >= end){
            return true;
        }
        int root = sequence[end];
        int i = start;

//        for (; i <= end; i++) {
//            if (sequence[i] > root){
//                break;
//            }
//        }

        while(sequence[i] < root){
            ++i;
        }
        int j = i;
        for ( ; j < end; j++) {
            if (sequence[j] < root){
                return false;
            }
        }

        boolean left = true;
        if (i > 0){
            left = VerifySquenceOfBSTCore(sequence, start, i - 1);
        }

        boolean right = true;
        if (j < end - 1){
            right = VerifySquenceOfBSTCore(sequence, i, end - 1);
        }

        return left && right;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,6,9,11,10,8};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
