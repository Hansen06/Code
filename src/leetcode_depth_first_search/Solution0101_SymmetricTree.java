package leetcode_depth_first_search;

/**
 * 101 Symmetric Tree
 */
public class Solution0101_SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null){
            return true;
        }
        if (root == null || root1 == null){
            return false;
        }
        if (root.val != root1.val){
            return false;
        }
        return isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
    }

}
