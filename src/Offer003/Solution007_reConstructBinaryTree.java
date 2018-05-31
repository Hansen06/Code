package Offer003;

/*
 * 重建二叉树
 */
public class Solution007_reConstructBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }

        int preLen = pre.length;
        int inLen = in.length;
        return ConstructCore(0, preLen - 1, 0, inLen - 1, pre, in);
    }

    private TreeNode ConstructCore(int preStart, int preEnd, int inStart, int inEnd, int[] pre, int[] in) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(0);
        root.val = rootValue;

        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]){
                root.left = ConstructCore(preStart + 1, preStart + i -inStart, inStart, i - 1, pre, in);
                root.right = ConstructCore(i - inStart + preStart + 1, preEnd, i + 1, inEnd, pre, in);
                break;
            }
        }
        return root;
    }

}
