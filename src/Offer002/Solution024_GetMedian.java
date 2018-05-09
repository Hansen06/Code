package Offer002;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ]数据流中的中位数
 */
public class Solution024_GetMedian {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());


    public static void Insert(Integer num) {
        if (maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if (maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            if (minHeap.isEmpty()){
                minHeap.add(num);
                return;
            }
            if (minHeap.peek() > num){
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }
        }
        if (maxHeap.size() - minHeap.size() > 1 ){
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    public static Double GetMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0){
            return null;
        }

        Integer maxHeapHead = maxHeap.peek();//使用int会报空指针，封装类型可以接受null
        Integer minHeapHead = minHeap.peek();
        if (((maxHeapSize + minHeapSize) % 2) == 0){
            return (double) (maxHeapHead + minHeapHead) / 2;
        }
        return (double) (maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead);

    }

    public static class MaxHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
    }
}