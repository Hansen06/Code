package offer003;

/**
 * 平衡二叉树  存在问题
 */
public class Solution055_2_2_IsBalanced_Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }

        int depth = 0;
        return IsBalanced(root, depth);
    }

    private static boolean IsBalanced(TreeNode root, int depth) {
        if (root == null){
            return true;
        }
        int left = 0;
        int right = 0;
        if (IsBalanced(root.left, left) && IsBalanced(root.right, right)){
            int dif = left - right;
            if (dif > 1 || dif < -1){
                return false;
            }
            depth = (left > right ? left : right) + 1;
            return true;
        }
        return false;
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

        System.out.println(IsBalanced_Solution(root));

    }
}
