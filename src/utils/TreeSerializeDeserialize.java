package utils;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSerializeDeserialize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head) {
        if (head == null) {
            return "#,";
        }
        String res = head.value + ",";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public static Node Deserialize(String str){
        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }
        return preOrder(queue);
    }

    private static Node preOrder(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")){
            return null;
        }
        Node node = new Node(Integer.valueOf(val));
        node.left = preOrder(queue);
        node.right = preOrder(queue);
        return node;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        String str = serialByPre(t1);
        System.out.println(str);
        Node reNode = Deserialize(str);
        String str1 = serialByPre(reNode);
        System.out.println(str1);


    }

}
