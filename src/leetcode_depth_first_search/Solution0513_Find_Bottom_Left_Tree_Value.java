package leetcode_depth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0513_Find_Bottom_Left_Tree_Value {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        int left = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (!queue1.isEmpty()){
                left = queue1.peek().val;
            }
            while (!queue1.isEmpty()){
                TreeNode tmp = queue1.poll();
                if (tmp.left != null){
                    queue2.add(tmp.left);
                }
                if (tmp.right != null){
                    queue2.add(tmp.right);
                }
            }
            if (!queue2.isEmpty()){
                left = queue2.peek().val;
            }
            while (!queue2.isEmpty()){
                TreeNode tmp = queue2.poll();
                if (tmp.left != null){
                    queue1.add(tmp.left);
                }
                if (tmp.right != null){
                    queue1.add(tmp.right);
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
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
        System.out.println(findBottomLeftValue(root));
    }

}
