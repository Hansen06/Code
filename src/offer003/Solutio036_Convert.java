package offer003;

/**
 * 二叉搜索树与双向链表
 */
public class Solutio036_Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeList = new TreeNode(-1);
        CovertNode(pRootOfTree, pLastNodeList);

        TreeNode pHeadOfList = pLastNodeList;
        while (pHeadOfList != null && pHeadOfList.left != null){
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private void CovertNode(TreeNode pNode, TreeNode pLastNodeList) {
        if (pNode == null){
            return;
        }

        TreeNode pCur = pNode;
        if (pCur.left != null){
            CovertNode(pCur.left, pLastNodeList);
        }

        pCur.left = pLastNodeList;
        if (pLastNodeList != null){
            pLastNodeList.right = pCur;
        }
        pLastNodeList = pCur;

        if (pCur.right != null){
            CovertNode(pCur.right, pLastNodeList);
        }
    }

}
