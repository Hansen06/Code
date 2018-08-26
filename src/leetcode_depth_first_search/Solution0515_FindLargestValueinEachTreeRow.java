package leetcode_depth_first_search;
/**
 * Find Largest Value in Each Tree Row
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0515_FindLargestValueinEachTreeRow {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        long max = Long.MIN_VALUE;
        while (!queue1.isEmpty() || !queue2.isEmpty()){

            while (!queue1.isEmpty()){
                TreeNode tmp = queue1.poll();
                if (tmp.val > max){
                    max = tmp.val;
                }
                if (tmp.left != null){
                    queue2.add(tmp.left);
                }
                if (tmp.right != null){
                    queue2.add(tmp.right);
                }
            }
            if (max != Long.MIN_VALUE){
                list.add((int)max);
            }
            max = Long.MIN_VALUE;
            while (!queue2.isEmpty()){
                TreeNode tmp = queue2.poll();
                if (tmp.val > max){
                    max = tmp.val;
                }
                if (tmp.left != null){
                    queue1.add(tmp.left);
                }
                if (tmp.right != null){
                    queue1.add(tmp.right);
                }
            }
            if (max != Long.MIN_VALUE){
                list.add((int)max);
            }
            max = Long.MIN_VALUE;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.left = node5;
        List<Integer> list = new ArrayList<>();
        list = largestValues(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


}
