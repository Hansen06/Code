package Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数
 */
public class Solution025_GetLeastNumbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k){
            return result;
        }
        PriorityQueue<Integer> kQueue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            kQueue.add(input[i]);
        }

        for (int i = 0; i < k; i++) {
            result.add(kQueue.poll());
        }

        return result;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k == 0){
            return result;
        }
        PriorityQueue<Integer> kQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (kQueue.size() < k){
                kQueue.add(input[i]);
            }else if (kQueue.peek() > input[i]){
                kQueue.poll();
                kQueue.add(input[i]);
            }
        }
        for (Integer num : kQueue) {
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = new ArrayList<>();
        res = GetLeastNumbers_Solution1(arr, 0);
        for (int i = 0; i < res.size();i++) {
            System.out.print(res.get(i) + " ");
        }

    }
}
