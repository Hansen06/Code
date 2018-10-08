package offer003;

/**
 * 序列化二叉树
 */
public class Solution037_Serialize_Deserialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static int index = -1;
    public static String Serialize(TreeNode root) {
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

    public static TreeNode Deserialize(String str) {
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

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        TreeNode root_left  = new TreeNode(2);
        TreeNode root_right = new TreeNode(3);
        TreeNode root_left_left  = new TreeNode(4);
        TreeNode root_left_right  = new TreeNode(5);
        root.left = root_left;
        root.right = root_right;
        root_left.left = root_left_left;
        root_left.right = root_left_right;

        String res  = Serialize(root);
        System.out.println(res);

        TreeNode node = Deserialize(res);
        System.out.println(Serialize(node));

    }

}
