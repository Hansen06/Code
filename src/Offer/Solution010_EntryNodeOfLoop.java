package Offer;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

public class Solution010_EntryNodeOfLoop {

    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode MeetingNode1(ListNode pHead){
        if (pHead == null){
            return null;
        }

        ListNode sNode = pHead;
        ListNode fNode = pHead;

        while (sNode != null && fNode != null){
            if(sNode == null){
                return null;
            }

            sNode = sNode.next;
            fNode = fNode.next;
            if(fNode != null){
                fNode = fNode.next;
            }

            if (fNode == sNode){
                return sNode;
            }
        }
        return null;
    }

    public static ListNode MeetingNode(ListNode pHead){
        if (pHead == null){
            return null;
        }

        ListNode sNode = pHead.next;
        if(sNode.next == null){
            return null;
        }
        ListNode fNode = sNode.next;

        while (sNode != null && fNode != null){
            if (fNode == sNode){
                return sNode;
            }
            sNode = sNode.next;
            fNode = fNode.next;
            if(fNode != sNode){
                fNode = fNode.next;
            }
        }
        return null;
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {

        ListNode meetNode = MeetingNode(pHead);
        if(meetNode == null){
            return null;
        }
        int count = 1;
        ListNode pNode = meetNode;
        while (pNode.next != meetNode){
            pNode = pNode.next;
            count++;
        }

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(count > 0){
            p1 = p1.next;
            count--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
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
        node5.next = node2;

        ListNode node = EntryNodeOfLoop(head);
        System.out.println(node.val);
    }

}
