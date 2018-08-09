package leetcode_depth_first_search;

import java.util.concurrent.TransferQueue;

/**
 * Convert Sorted Array to Binary Search Tree
 */
public class Solution0108_ConvertSortedArraytoBinarySearchTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null){
            return null;
        }
        TreeNode root  = rebuiltBlanceTree(nums, 0, nums.length-1);
        return root;
    }

    private static TreeNode rebuiltBlanceTree(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = rebuiltBlanceTree(nums, left, mid - 1);
        node.right = rebuiltBlanceTree(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println();

    }
}
