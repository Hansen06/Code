package Offer003;

import java.util.Stack;

/**
 * 二叉树的镜像
 */
public class Solution027_Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 非递归实现
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tree = stack.pop();
            if (tree.left != null || tree.right != null){
                TreeNode temp = tree.left;
                tree.left = tree.right;
                tree.right = temp;
            }
            if (tree.left != null){
                stack.push(tree.left);
            }
            if (tree.right != null){
                stack.push(tree.right);
            }
        }
    }

    /**
     * 递归实现
     * @param root
     */
    public void Mirror1(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            Mirror1(root.left);
        }
        if (root.right != null){
            Mirror1(root.right);
        }
    }
}
