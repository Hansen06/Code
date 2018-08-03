package offer002;

import java.util.Stack;

/**
 * 两个链表的第一个公共结点
 */
public class Solution52_FindFirstCommonNode {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }

        ListNode meeting = null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode temp = null;
        while (!stack1.empty() && !stack2.empty()){
            if (stack1.peek().val == stack2.peek().val){
                meeting = stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return meeting;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(9);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode head2 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node21 = new ListNode(5);
        ListNode node31 = new ListNode(7);
        ListNode node41 = new ListNode(9);

        head2.next = node11;
        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        node41.next = null;

        System.out.println(FindFirstCommonNode(head1, head2).val);
    }


}
