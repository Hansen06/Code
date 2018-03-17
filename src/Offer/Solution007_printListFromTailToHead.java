package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution007_printListFromTailToHead {

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        if (listNode == null){
            return list;
        }
        for (ListNode tmp = listNode; tmp != null; tmp = tmp.next){
            stack.push(tmp.val);
        }

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        for (int val : list) {
            System.out.println(val);
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);
        return list;
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

        ArrayList<Integer> list  = printListFromTailToHead(head);
        for (int val: list) {
            System.out.println(val);
        }
    }

}
