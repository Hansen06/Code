package offer004;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 */
public class Solution054_KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (pRoot == null || k <= 0){
            return null;
        }

        TreeNode head = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                list.add(head);
                head = head.right;
            }
        }
        if (k > list.size()){
            return null;
        }
        return list.get(k-1);
    }
}
