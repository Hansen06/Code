package leetcode_depth_first_search;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.*;
/**
 * Binary Tree Paths
 */
public class Solution0257_BinaryTreePaths {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        dfs(root, queue, list);
        return list;
    }

    public static void dfs(TreeNode root, Queue<Integer> queue, List<String> path){
        if (root == null){
            return ;
        }
        if (root.left == null && root.right == null){
            StringBuffer pt = new StringBuffer();
            for (int i : queue) {
                pt.append(i + "->");
            }
            pt.append(root.val);
            path.add(pt.toString());
        }

        queue.add(root.val);
        if (root.left != null){
            dfs(root.left, queue, path);
        }
        if (root.right != null){
            dfs(root.right, queue, path);
        }
        queue.poll();
    }


    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null){
            dfsSearch(root, "", result);
        }
        return result;
    }

    private static void dfsSearch(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null){
            result.add(path + root.val);
        }
        if (root.left != null){
            dfsSearch(root.left, path + root.val + "->", result);
        }
        if (root.right != null){
            dfsSearch(root.right, path + root.val + "->", result);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        List<String> list = new ArrayList<>();
        list = binaryTreePaths1(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
