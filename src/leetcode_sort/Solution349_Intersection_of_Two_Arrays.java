package leetcode_sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class Solution349_Intersection_of_Two_Arrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > max) {
                max = nums1[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > max) {
                max = nums2[i];
            }
        }
        int[] help = new int[max + 1];
        for (int i = 0; i < nums1.length; i++) {
            help[nums1[i]] = 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (help[nums2[i]] == 1) {
                set.add(nums2[i]);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res[index] = (int) it.next();
            index++;
        }
        return res;
    }

    /**
     * 两个set
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res[index] = (int) it.next();
            index++;
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }

        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums2, nums1[i])){
                set.add(nums1[i]);
            }
        }

        int index = 0;
        int[] res = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res[index] = (int) it.next();
            index++;
        }
        return res;
    }

    private static boolean binarySearch(int[] nums2, int num) {
        int low = 0;
        int high = nums2.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums2[mid] > num){
                high = mid - 1;
            }else if (nums2[mid] < num){
                low = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4, 5};
        int[] result = intersection2(nums3, nums4);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
