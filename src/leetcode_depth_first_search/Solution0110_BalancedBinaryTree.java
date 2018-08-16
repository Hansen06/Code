package leetcode_depth_first_search;

/**
 * Balanced Binary Tree
 */
public class Solution0110_BalancedBinaryTree {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = hightTree(root.left);
        int right = hightTree(root.right);
//        if (((left-right) > 1) || ((right - left) < -1)){
//                return false;
//        }

        if (Math.abs(left-right) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int hightTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = hightTree(root.left);
        int right = hightTree(root.right);
        return (left > right) ? left + 1 : right + 1;
    }
}
