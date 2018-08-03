package offer003;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 */

public class Solution032_02_Print {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return ;
        }

        int nextLevel = 0;
        int toBePrinted = 1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.val + " ");
            --toBePrinted;
            if (tmp.left != null) {
                queue.add(tmp.left);
                ++nextLevel;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                ++nextLevel;
            }
            if (toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null){
            return result;
        }

        int toBePrint = 1;
        int nextLevel = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> curRes = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            curRes.add(tmp.val);
            --toBePrint;
            if (tmp.left != null){
                queue.add(tmp.left);
                ++nextLevel;
            }
            if (tmp.right != null){
                queue.add(tmp.right);
                ++nextLevel;
            }

            if (toBePrint == 0){
                result.add(curRes);
                toBePrint = nextLevel;
                nextLevel = 0;
                curRes = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        PrintFromTopToBottom(root);
    }
}
