package Offer;

import homework01.ReverseList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */

public class Solution005 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {

        if(head == null){
            return null;
        }

        int len = 0;
        for (ListNode p = head; p != null; p = p.next){
            len = len + 1;
        }
        if (len == 1){
            System.out.println(head.val);
            return head;
        }

        int[] arr = new int[len];
        int i = 0;
        for (ListNode p = head; p != null; p = p.next){
            arr[i++] = p.val;
        }

//        ListNode p = head;
//        while (p != null){
//            arr[i++] = p.val;
//            p = p.next;
//        }

        ListNode oldfirst = new ListNode(arr[0]);
        ListNode first = null;

        for (int j = 1; j < arr.length; j++) {
            first = new ListNode(arr[j]);
            first.next = oldfirst;
            oldfirst = first;
        }

        for (ListNode q = first; q != null; q = q.next){
            System.out.println(q.val);
        }

        return first;
    }

    public static ListNode ReverseList1(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode temp = head;
        while(temp != null){
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }

        for (ListNode q = pre; q != null; q = q.next){
            System.out.println(q.val);
        }

        return pre;
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

        for (ListNode x = head; x!= null; x = x.next){
            System.out.println(x.val);
        }

        ReverseList(head);

        ListNode list = ReverseList(head);

        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }

        System.out.println("------------------------");
        ListNode list1 = ReverseList1(head);

    }

}
