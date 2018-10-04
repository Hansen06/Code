package leetcode_sort;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution350_Intersection_of_Two_Arrays_II {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }

        LinkedList<Integer> list1 = new LinkedList<>();
        ArrayList<Integer> res_list = new ArrayList<>();

        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                list1.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (list1.contains(nums1[i])) {
                    res_list.add(nums1[i]);
                    list1.remove(list1.indexOf(nums1[i]));
                }
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                list1.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (list1.contains(nums2[i])) {
                    res_list.add(nums2[i]);
                    list1.remove(list1.indexOf(nums2[i]));
                }
            }
        }

        int[] res = new int[res_list.size()];
        int i = 0;
        for (int j = 0; j < res_list.size(); j++) {
            res[i++] = (int) res_list.get(j);
        }
        return res;
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1}, nums2 = {1, 1};
//        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] res = intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
