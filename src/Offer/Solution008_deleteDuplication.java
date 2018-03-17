package Offer;

import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 */
public class Solution008_deleteDuplication {

    public static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode curNode = pHead;
        ListNode preNode = newHead;
        ListNode nextNode = null;
        while (curNode != null && curNode.next != null){
            nextNode = curNode.next;
            if (nextNode.val == curNode.val){
                while(nextNode != null && nextNode.val == curNode.val){ // nextNode != null 有移动指针的过程，需判断后面是否为空
                    nextNode = nextNode.next;
                }
                preNode.next = nextNode;
                curNode = nextNode;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }

        }
        return newHead.next;
    }

    /**
     * 递归实现
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication1(ListNode pHead)
    {

        if(pHead == null || pHead.next == null){
            return pHead;
        }

        if(pHead.val == pHead.next.val){
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val){
               pNode = pNode.next;
            }
            return deleteDuplication1(pNode);
        }else{
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        }
    }

    public static ListNode deleteDuplication2(ListNode pHead){

        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode curNode = pHead;
        ListNode preNode = null;
        while (curNode != null){
            ListNode nextNode = curNode.next;
            boolean needDelete = false;
            if (nextNode != null && nextNode.val == curNode.val){
                needDelete = true;
            }

            if(!needDelete){
                preNode = curNode;
                curNode = curNode.next;
            }else{
                int value = curNode.val;
                ListNode pToBeDel = curNode;
                while (pToBeDel != null && pToBeDel.val == value){
                    nextNode = pToBeDel.next;
                    pToBeDel = nextNode;
                }
                if(preNode == null){
                    pHead = nextNode;
                }else {
                    preNode.next = nextNode;
                }
            }
            curNode = nextNode;
        }
        return pHead;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode node = deleteDuplication(head);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
