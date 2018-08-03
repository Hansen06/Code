package offer003;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

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

    /**
     * 有问题
     * @param num
     * @param size
     * @return
     */
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

        if(num == null || num.length == 0 || size == 0 || size > num.length) {
            return result;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < num.length; i++) {
            if(!queue.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i >= queue.peek() + size) {
                    queue.pop();
                }

                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.offer(i); // 入队列

            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if(i + 1 >= size) {
                result.add(num[queue.peek()]);
            }
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
