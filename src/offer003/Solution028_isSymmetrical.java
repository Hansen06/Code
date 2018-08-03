package offer003;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 对称的二叉树
 */
public class Solution028_isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
        if (pRoot.left == null && pRoot == null){
            return true;
        }

        ArrayList<Integer> list_pre = new ArrayList<>();
        ArrayList<Integer> list_rev = new ArrayList<>();

        list_pre = preOrder(pRoot);
        list_rev = revpreOrder(pRoot);

        if (list_pre.size() != list_rev.size()){
            return false;
        }
        for (int i = 0; i < list_pre.size(); i++) {
            if (list_pre.get(i) != list_rev.get(i)){
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> preOrder(TreeNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                list.add(head.val);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        return list;
    }

    private ArrayList<Integer> revpreOrder(TreeNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                list.add(head.val);
                if (head.left != null){
                    stack.push(head.left);
                }
                if (head.right != null){
                    stack.push(head.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(8);
        list1.add(6);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list1.add(7);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(8);
        list2.add(9);
        list2.add(5);
        list2.add(7);
        list2.add(6);
        list2.add(7);
        list2.add(5);

        System.out.println(list1.containsAll(list2) && list1.containsAll(list2));
    }
}
