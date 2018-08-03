package offer003;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 把二叉树打印zigzag
 */

public class Solution032_03_Print {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null){
            return result;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int level = 1;
        s1.push(pRoot);

        while (!s1.isEmpty() || !s2.isEmpty()){

            if (level % 2 != 0){
                ArrayList<Integer> curRes = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode tmp = s1.pop();
                    curRes.add(tmp.val);

                    if (tmp.left != null) {
                        s2.push(tmp.left);
                    }
                    if (tmp.right != null) {
                        s2.push(tmp.right);
                    }
                }
                result.add(curRes);
                level++;
            }else {
                ArrayList<Integer> curRes = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode tmp = s2.pop();
                    curRes.add(tmp.val);
                    if (tmp.right != null) {
                        s1.push(tmp.right);
                    }
                    if (tmp.left != null) {
                        s1.push(tmp.left);
                    }
                }
                result.add(curRes);
                level++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);
        TreeNode node10 = new TreeNode(11);
        TreeNode node11 = new TreeNode(12);
        TreeNode node12 = new TreeNode(13);
        TreeNode node13 = new TreeNode(14);
        TreeNode node14 = new TreeNode(15);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        node4.left = node9;
        node4.right = node10;

        ArrayList<ArrayList<Integer>> res = Print(root);
        for (ArrayList<Integer> list: res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
