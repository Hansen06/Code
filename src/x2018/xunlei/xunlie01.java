package x2018.xunlei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class xunlie01 {

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("-");
        String[] f_arr = arr[0].split(",");
        String[] s_arr = arr[1].split(":")[0].split(",");

        int[] fir = new int[f_arr.length];
        int[] sec = new int[s_arr.length];
        for (int i = 0; i < f_arr.length; i++) {
            fir[i] = Integer.valueOf(f_arr[i]);
        }
        for (int i = 0; i < s_arr.length; i++) {
            sec[i] = Integer.valueOf(s_arr[i]);
        }

        int k = Integer.valueOf(arr[1].split(":")[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());

        Arrays.sort(fir);
        Arrays.sort(sec);
        int num = 0;
        if (k % 2 == 0){
            num = k / 2;
        }else {
            num = k / 2 + 1;
        }

        for (int i = fir.length - 1; i >= fir.length - num ; i--) {
            for (int j = sec.length - 1; j >= sec.length - num; j--) {
                int cur_sum = fir[i] + sec[j];
                if (minHeap.size() < k) {
                    minHeap.add(cur_sum);
                } else {
                    int maxInQueue = minHeap.peek();
                    if (maxInQueue < cur_sum) {
                        minHeap.poll();
                        minHeap.add(cur_sum);
                    }
                }
            }
        }
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = minHeap.poll();

        }
        for (int i = 0; i < k - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[k-1]);
    }
}
