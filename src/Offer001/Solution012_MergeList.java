package Offer001;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution012_MergeList {


    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null){
            if (list2 == null){
                return list1;
            }else{
                return list2;
            }
        }else {
            if (list2 == null){
                return list1;
            }
        }

        ListNode newHead = new ListNode(-1);

        ListNode tmp = newHead;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                tmp.next = p1;
                tmp = p1;
                p1 = p1.next;
            }else{
                tmp.next = p2;
                tmp = p2;
                p2 = p2.next;
            }

        }
        if (p1 != null){
            tmp.next = p1;
        }

        if(p2 != null){
            tmp.next = p2;
        }

        return newHead.next;
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
        ListNode node21 = new ListNode(6);
        ListNode node31 = new ListNode(8);
        ListNode node41 = new ListNode(10);

        head2.next = node11;
        node11.next = node21;
        node21.next = node31;
        node31.next = node41;
        node41.next = null;

        ListNode node = Merge(head1, head2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
