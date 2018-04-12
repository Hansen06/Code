package basic_class_04;

import java.util.Stack;

public class Code_5_BinaryTreeTraversal {

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static void preTraversalRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " ");
        preTraversalRecur(head.left);
        preTraversalRecur(head.right);
    }

    private static void inTraversalRecur(Node head){
        if (head == null){
            return;
        }
        inTraversalRecur(head.left);
        System.out.print(head.data + " ");
        inTraversalRecur(head.right);
    }

    private static void posTraversalRecur(Node head){
        if (head == null){
            return;
        }
        posTraversalRecur(head.left);
        posTraversalRecur(head.right);
        System.out.print(head.data + " ");
    }


    private static void preTraversalUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.data + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
//        System.out.println();
    }

    public static void inTraversalUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.data + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void posTraversalUnRecur(Node head){
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null){
                    stack1.push(head.left);
                }
                if (head.right != null){
                    stack1.push(head.right);
                }
            }

            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().data + " ");
            }
        }
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        preTraversalRecur(head);
        System.out.println();
        inTraversalRecur(head);
        System.out.println();
        posTraversalRecur(head);


        System.out.println();
        System.out.println();
        preTraversalUnRecur(head);
        System.out.println();
        inTraversalUnRecur(head);
        System.out.println();
        posTraversalUnRecur(head);
    }
}
