package leetcode_depth_first_search;

/**
 * Minimum Depth of Binary Tree
 */
public class Solution0111_MinimumDepthofBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0){
            return left + right + 1;
        }else {
            return (left > right) ? right + 1 : left + 1;
        }
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

        System.out.println(minDepth(root));
    }
}
