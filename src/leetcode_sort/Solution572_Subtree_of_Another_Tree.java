package leetcode_sort;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class Solution572_Subtree_of_Another_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        String t1Str = serialByPre(s);
        String t2Str = serialByPre(t);
        System.out.println(t1Str);
        System.out.println(t2Str);
        return t1Str.contains(t2Str);
    }

    public static String serialByPre(TreeNode head) {
        if (head == null) {
            return "#,";
        }
        String res = head.val + ",";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }


    public static StringBuilder spre = new StringBuilder();
    public static StringBuilder tpre = new StringBuilder();

    public static boolean isSubtree1(TreeNode s, TreeNode t) {
        preOrder(s, spre.append(","));
        preOrder(t, tpre.append(","));
        System.out.println(spre.toString());
        System.out.println(tpre.toString());
        return spre.toString().contains(tpre.toString());
    }

    public static void preOrder(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        preOrder(root.left, str);
        preOrder(root.right, str);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);

        System.out.println(isSubtree(t1, t2));
        System.out.println(isSubtree1(t1, t2));
    }
}
