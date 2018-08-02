package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Maximum Depth of N-ary Tree
 */

public class Solution055901_MaximumDepthofNaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int max = 0;
    public static int maxDepth(Node root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return max;
    }

    public static void dfs(Node root, int depth) {
        if (root == null)
            return;
        max = Math.max(max, depth);
        for(Node node: root.children)
            dfs(node, depth+1);
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) { //replace left&right to for loop
            int value = maxDepth(child);

            if (value > max) {
                max = value;
            }
        }
        return max +1;
    }

    public static void main(String[] args) {
        Node node2 = new Node(3,new ArrayList<>());
        Node node3 = new Node(4,new ArrayList<>());
        Node node4 = new Node(5,new ArrayList<>());
        Node node5 = new Node(6,new ArrayList<>());

        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        list2.add(node4);
        list2.add(node5);

        Node node1 = new Node(2,list2);
        list1.add(node1);
        list1.add(node2);
        list1.add(node3);


        Node root = new Node(1,list1);


        System.out.println(maxDepth(root));
    }


}
