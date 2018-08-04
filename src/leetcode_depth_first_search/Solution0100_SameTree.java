package leetcode_depth_first_search;

import java.util.ArrayList;

/**
 * Same Tree
 */
public class Solution0100_SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void preTraverse(TreeNode root, ArrayList<String> list){
        if (root == null){
            list.add("#");
            return ;
        }
        list.add(String.valueOf(root.val));
        preTraverse(root.left, list);
        preTraverse(root.right, list);
    }

    public static boolean isSameTree(ArrayList<String> p_pre, ArrayList<String> q_pre){
        if (p_pre.size() != q_pre.size()){
            return false;
        }
        boolean isSame = true;
        int index_p = 0;
        int index_q = 0;
        while (index_p < p_pre.size() && index_q < q_pre.size()){
            if (!(p_pre.get(index_p).equals(q_pre.get(index_q)))){
                isSame = false;
            }
            index_p++;
            index_q++;
        }
        return isSame;
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        ArrayList<String> p_pre = new ArrayList<>();
        ArrayList<String> q_pre = new ArrayList<>();
        preTraverse(p, p_pre);
        preTraverse(q, q_pre);
        return isSameTree(p_pre, q_pre);
    }

    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.left = n1;
        root.right = n2;

        TreeNode root1 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n21 = new TreeNode(3);
        root1.left = n11;
        root1.right = n21;
        System.out.println(isSameTree(root, root1));
    }
}
