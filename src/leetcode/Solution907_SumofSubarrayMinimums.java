package leetcode;

import java.util.LinkedList;

/**
 * 907. Sum of Subarray Minimums
 */
public class Solution907_SumofSubarrayMinimums {

    public int sumSubarrayMins(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }

        return 0;
    }

    public static int[] getMinWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] >= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        printArray(getMinWindow(arr, 2));
    }
}
