package leetcode_depth_first_search;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Maximum Depth of N-ary Tree
 */

public class Solution0559_MaximumDepthofNaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(Node root) {
        if (root == null){
            return 0;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(root.val);
        stack.push(root);
        int depth = 0;
        System.out.println(root.val);
        while (!stack.isEmpty()){
            Node tmp = stack.pop();
            for (Node next : tmp.children){
                if (!set.contains(next.val)){
                    stack.push(tmp);
                    stack.push(next);
                    set.add(next.val);
                    System.out.println(next.val);
                    break;
                }
            }
        }
        return depth;
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

        maxDepth(root);
    }


}
