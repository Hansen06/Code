package Offer001;

/**
 * 反转链表
 */

public class Solution024_Reverse_Linked_List {

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

        ListNode newHead = null;
        ListNode next = null;
        ListNode temp = head;
        while(temp != null){
            next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }

//        for (ListNode q = newHead; q != null; q = q.next){
//            System.out.println(q.val);
//        }

        return newHead;
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


        System.out.println("-----------------------");

        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);

        node01.next = node02;
        node02.next = null;

        ListNode node111 = ReverseList1(node01);
        while(node111 != null){
            System.out.println(node111.val);
            node111 = node111.next;
        }

    }

}
