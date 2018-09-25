package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297_SerializeandDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        String str = root.val + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            queue.add(str[i]);
        }
        return deserializeCore(queue);
    }

    private static TreeNode deserializeCore(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeCore(queue);
        node.right = deserializeCore(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        t1.left.left.right = new TreeNode(8);
        t1.left.right.left = new TreeNode(9);

        String str = serialize(t1);
        System.out.println(str);
        TreeNode reNode = deserialize(str);
        String str1 = serialize(reNode);
        System.out.println(str1);
    }
}
