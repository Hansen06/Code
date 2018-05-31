package Offer003;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 */
public class Solution059_maxInWindows {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || num.length < size || size == 0) {
            return result;
        }

        for (int i = 0; i <= num.length - size; i++) {
            int max = num[i];
            for (int j = i + 1; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            result.add(max);
        }

        return result;
    }

    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || num.length < size || size == 0) {
            return result;
        }

        ArrayDeque<Integer> indexQ = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!indexQ.isEmpty() && num[i] > num[indexQ.getLast()]) {
                indexQ.pollLast();
            }
            indexQ.push(i);
        }

        System.out.println(indexQ.getFirst());

        for (int i = size; i < num.length; i++) {
            result.add(num[indexQ.getFirst()]);

            while (!indexQ.isEmpty() && num[i] >= num[indexQ.getLast()]) {
                indexQ.pollLast();
            }
            if (!indexQ.isEmpty() && indexQ.getFirst() <= (i - size)) {
                indexQ.peekLast();
            }
        }
        result.add(num[indexQ.getFirst()]);
        return result;
    }

    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || num.length < size || size == 0) {
            return result;
        }
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
            else if (begin > q.peekFirst())
                q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if (begin >= 0)
                result.add(num[q.peekFirst()]);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 5, 7, 9, 11, 13, 15};
        ArrayList<Integer> res = maxInWindows2(num, 3);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

//        int[] num = {1,6,5,7,9,11,13,15};
//        ArrayDeque<Integer> indexQ = new ArrayDeque<>();
//
//
//        for (int i = 0; i < 5; i++) {
//            indexQ.push(i);
//        }

//        System.out.println(indexQ.getLast());
//        System.out.println(indexQ.getFirst());


//        for (int i = 0; i < 3; i++) {
//            while (!indexQ.isEmpty() && num[i] > num[indexQ.getLast()]){
//                System.out.println(indexQ.getLast());
//                System.out.println("----");
//                System.out.println(num[indexQ.getLast()]);
//                indexQ.pollLast();
//            }
//            indexQ.push(i);
//        }
//        System.out.println(" ==========");
//        System.out.println(indexQ.poll());
    }
}
