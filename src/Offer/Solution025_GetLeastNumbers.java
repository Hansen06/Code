package Offer;

import utils.Partition;

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

    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k == 0){
            return result;
        }

        int start = 0;
        int end = input.length - 1;
        int index = Partition.Partition2(input, start, end);
        System.out.println(index);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = Partition.Partition2(input, start, end);
            }else {
                start = index + 1;
                index = Partition.Partition2(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }


    public static int Partition(int[] data, int start, int end){
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(data, index, end);
        int p = data[end];
        int less = start - 1;
        for ( index = start; index < end; index++){
            if (data[index] < data[end]){
                ++less;
                if (less != index){
                    swap(data, index, less);
                }
            }
        }
        ++less;
        swap(data, less, end);
        return less;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = new ArrayList<>();
        res = GetLeastNumbers_Solution2(arr, 3);
        for (int i = 0; i < res.size();i++) {
            System.out.print(res.get(i) + " ");
        }

    }
}
