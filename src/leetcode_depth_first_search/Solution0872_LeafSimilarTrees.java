package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 *Leaf-Similar Trees
 */
public class Solution0872_LeafSimilarTrees {
    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static ArrayList<Integer> getLeafNode(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> leaf_result = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            set.add(node);
            if (node.left == null && node.right == null){
                leaf_result.add(node.val);
                continue;
            }
            boolean flag = false;
            if (node.right != null && !set.contains(node.right)){
                stack.push(node);
                flag = true;
                stack.push(node.right);
            }
            if (node.left != null && !set.contains(node.left)){
                if (!flag) {
                    stack.push(node);
                    stack.push(node.left);
                }else {
                    stack.push(node.left);
                }
            }
        }
        return leaf_result;
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null){
            return false;
        }
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
        leaf1 = getLeafNode(root1);
        leaf2 = getLeafNode(root2);
        if (leaf1.size() != leaf2.size()){
            return false;
        }
        int index = 0;
        while(index < leaf1.size()){
            if (leaf1.get(index) != leaf2.get(index)){
                return false;
            }
            index++;
        }
        return true;
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

        ArrayList<Integer> list = new ArrayList<>();
        list = getLeafNode(root);
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        System.out.println(leafSimilar(root, root));

    }

}
