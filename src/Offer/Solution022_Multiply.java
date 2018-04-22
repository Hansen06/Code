package Offer;

public class Solution022_Multiply {

    public static int[] multiply(int[] A){
        if (A == null || A.length < 2){
            return A;
        }
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        //计算下三角连乘
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1]*A[i-1];
        }

        int tem= 1;
        //计算上三角连乘
        for (int i = len-2; i >=0 ; i--) {
            tem = tem*A[i+1];
            B[i] = B[i]*tem;
        }
        return B;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[] B = multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
