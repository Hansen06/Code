package offer003;

/**
 * 二叉树的下一个结点
 */
public class Solution008_GetNext {


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }

        TreeLinkNode pNext = null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCur = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCur == pParent.right) {
                pCur = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
