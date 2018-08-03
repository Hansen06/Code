package offer003;

/**
 * 平衡二叉树  存在问题
 */
public class Solution055_2_2_1_IsBalanced_Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    private static boolean isBalanced = true;
    public static boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }

    private static int getDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left-right)>1){
            isBalanced = false;
        }

        return (left > right) ? left + 1 : right + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

//        root.left = node1;
//        root.right = node2;
//
//        node1.left = node3;
//        node1.right = node4;
//
//        node4.left = node5;

        System.out.println(IsBalanced_Solution(root));

    }
}
