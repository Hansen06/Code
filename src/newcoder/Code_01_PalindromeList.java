package newcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 回文链表
 */
public class Code_01_PalindromeList {


    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int value){
            this.val = value;
        }
    }


    public static boolean isPalindrome(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode cur = pHead;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }

        ListNode p = pHead;
        while (p != null){
            if (stack.pop() != p.val){
                return false;
            }
            p = p.next;
        }
        return true;
    }

    public static boolean isPalindrome1(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return true;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (slow != null){
            stack.push(slow.val);
            slow = slow.next;
        }

        while (!stack.isEmpty()){
            if (pHead.val != stack.pop()){
                return false;
            }
            pHead = pHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }

        System.out.println(isPalindrome1(head));

    }
}
