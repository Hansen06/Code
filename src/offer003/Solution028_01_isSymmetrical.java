package offer003;

import java.util.ArrayList;

/**
 * 对称的二叉树
 */
public class Solution028_01_isSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    boolean isSymmetrical(TreeNode pRoot){
       return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null && pRoot1 == null){
            return true;
        }
        if (pRoot == null || pRoot1 == null){
            return false;
        }
        if (pRoot.val != pRoot1.val){
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot1.right) && isSymmetrical(pRoot.right, pRoot1.left);
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
