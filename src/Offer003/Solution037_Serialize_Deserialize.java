package Offer003;

/**
 * 序列化二叉树
 */
public class Solution037_Serialize_Deserialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer ser = new StringBuffer();
        if (root == null){
            ser.append("#,");
            return ser.toString();
        }
        ser.append(root.val + ",");
        ser.append(Serialize(root.left));
        ser.append(Serialize(root.right));
        return ser.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
