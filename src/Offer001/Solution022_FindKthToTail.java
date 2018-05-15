package Offer001;

import java.util.ArrayList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution022_FindKthToTail {

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {

        if(head == null || k < 1){
            return null;
        }

        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        int len = 0;
        while (node != null) {
            list.add(node);
            node = node.next;
            len = len + 1;
        }

        if(k > len){
            return null;
        }

        ListNode kNode = list.get(len-k);
        return kNode;
    }

    public static ListNode FindKthToTail1(ListNode head,int k) {

        if(head == null || k < 1){
            return null;
        }

        ListNode fNode = head;
        ListNode sNode = head;
        int i = 1;
        while(i < k){
            if(fNode.next != null){
                fNode = fNode.next;
                i++;
            }else{                    //k的长度大于链表长度
                return null;
            }

        }
        while(fNode.next != null){
            fNode = fNode.next;
            sNode = sNode.next;
        }
        return sNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode node = FindKthToTail(head,4);
        System.out.println(node.val);

        ListNode node_ = FindKthToTail1(head,4);
        if(node_ != null){
            System.out.println(node_.val);
        }


    }
}
