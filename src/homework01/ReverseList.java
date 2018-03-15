package homework01;


import java.util.Stack;

/**
 * 反转链表 (25)
 * 给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。
 * 例如：给定L为1→2→3→4→5→6，K为3，则输出应该为 3→2→1→6→5→4；
 * 如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。
 */
public class ReverseList {


    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }


    public static ListNode ReverList(ListNode head , int  K){

//        if(head == null){
//            return null;
//        }
//        int len = 0;
//        for (ListNode p = head; p != null; p = p.next){
//            len = len + 1;
//        }
//        if (len == 1 || len == 2){
//            return head;
//        }

        if(K < 2){
            return head;
        }
        Stack<Integer> stack = new Stack<Integer>();

        ListNode nodeHead = null;
        ListNode last = nodeHead;
        int i = 1;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            stack.push(temp.val);
            if(i == K){
                while (!stack.empty()){
                    ListNode oldlast = null;
                    last  = new ListNode(stack.pop());
                    oldlast.next = last;
                    oldlast = last;
                }
                i = 0;
            }
            i++;
        }

        return nodeHead;
    }



    public static  ListNode inverse(ListNode head, int K){
        if(K < 2){
            return head;
        }
        ListNode cur = head;
        ListNode start = null;
        ListNode pre = null;
        ListNode next = null;
        int count = 1;
        while (cur != null){
            next = cur.next;
            if(count == K){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign(ListNode left, ListNode start, ListNode end, ListNode right){
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;
        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left != null){
            left.next = end;
        }
        start.next = right;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        for (ListNode tmp = head; tmp != null; tmp = tmp.next){
            System.out.println(tmp.val);
        }

        System.out.println("-----------------------");

//        ListNode node  = ReverList(head);

        ListNode node = inverse(head, 3);
        for (ListNode p = node; p != null; p = p.next){
            System.out.println(p.val);
        }

    }
}
