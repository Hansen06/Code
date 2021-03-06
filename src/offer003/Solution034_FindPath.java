package offer003;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
 */
public class Solution034_FindPath {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathRe = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return pathRe;
        }
        Stack<Integer> stack = new Stack<>();
        FindPath(root, target, pathRe, stack);
        return pathRe;
    }

    private static void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> pathRe, Stack<Integer> stack) {

        if (root == null){
            return;
        }

        //如果是叶结点，并且路径上节点值得和等于输入的值，将该路径添加到结果集
        boolean isLeaf = root.left == null && root.right == null;
        if (root.val == target && isLeaf){
            ArrayList<Integer> curResult = new ArrayList<>();
            for (int i  : stack) {
                curResult.add(i);
            }
            curResult.add(root.val);
            pathRe.add(curResult);
        }

        stack.push(root.val);
        //如果不是叶节点，则遍历它的子节点
        if (root.left != null){
            FindPath(root.left, target - root.val, pathRe, stack);
        }
        if (root.right != null){
            FindPath(root.right, target - root.val, pathRe, stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        FindPath(root,4);
    }
}
