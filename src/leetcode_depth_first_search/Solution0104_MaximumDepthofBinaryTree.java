package leetcode_depth_first_search;

/**
 * Maximum Depth of Binary Tree
 */
public class Solution0104_MaximumDepthofBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right) ? left + 1: right + 1;
    }

}
