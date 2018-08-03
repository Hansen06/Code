package samsung;

import java.util.ArrayList;
import java.util.Stack;

public class GetNodePath {
    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }


    public static boolean hasNode(TreeNode  pRoot, TreeNode pNode){
        if(pRoot.val == pNode.val)
            return true;
        boolean has = false;
        if(pRoot.left != null)
            has = hasNode(pRoot.left, pNode);
        if(!has && pRoot.right != null){
            has = hasNode(pRoot.right, pNode);
        }
        return has;
    }


    public static boolean GetNodePath(TreeNode pRoot, TreeNode pNode, Stack<TreeNode> path){
        //先将当前节点入栈
        path.push(pRoot);

        if(pRoot.val == pNode.val)
            return true;
        //前序
        boolean found = false;
        if(pRoot.left != null) {
            found = GetNodePath(pRoot.left, pNode, path);
        }
        if(!found && pRoot.right != null) {
            found = GetNodePath(pRoot.right, pNode, path);
        }
        //如果此路径没有找到，出栈
        if(!found)
            path.pop();
        return found;
    }

    public static TreeNode getLastComNode(TreeNode[] path1, TreeNode[] path2){
        if (path1.length < 1 || path2.length < 1){
            return null;
        }
        int index1 = 0;
        int index2 = 0;
        TreeNode pLast = null;
        while (index1 < path1.length && index2 < path2.length){
            if (path1[index1].val == path2[index2].val){
                pLast = path1[index1];
            }
            index1++;
            index2++;
        }
        return pLast;
    }

    public static TreeNode getLastComParent(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || node1 == null || node2 == null){
            return null;
        }

        Stack<TreeNode> s_path1 = new Stack<>();
        GetNodePath(root, node1, s_path1);
        TreeNode[] path1 = new TreeNode[s_path1.size()];
        int i = s_path1.size() - 1;
        while (!s_path1.isEmpty()){
            path1[i] = s_path1.pop();
            i--;
        }

        Stack<TreeNode> s_path2 = new Stack<>();
        GetNodePath(root, node2, s_path2);
        TreeNode[] path2 = new TreeNode[s_path2.size()];
        int j = s_path2.size() - 1;
        while (!s_path2.isEmpty()){
            path2[j] = s_path2.pop();
            j--;
        }
        return getLastComNode(path1, path2);
    }

    public static int getTreeSize(TreeNode pRoot){
        if (pRoot == null){
            return 0;
        }
        int left_size = getTreeSize(pRoot.left);
        int right_size = getTreeSize(pRoot.right);
        return left_size + right_size + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);
        TreeNode node10 = new TreeNode(11);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        node4.left = node9;
        node4.right = node10;

        System.out.println(hasNode(root, new TreeNode(90)));
        System.out.println(hasNode(root, new TreeNode(1)));

        TreeNode comNode = getLastComParent(root, new TreeNode(4), new TreeNode(5));
        System.out.println(comNode.val);

        System.out.println(String.format("The size of child tree is %s", getTreeSize(comNode)));
//        ArrayList<TreeNode> list = new ArrayList<>();
//        list = getNodePath(root, pNode);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).val);
//        }

    }

    public static ArrayList<TreeNode> getNodePath(TreeNode root, TreeNode pNode){
        if (root == null){
            return null;
        }
        ArrayList<TreeNode> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curNode = null;
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            path.add(curNode);
            if (curNode.val == pNode.val){
                break;
            }
            if (curNode.left == null && curNode.right == null) {
                path.remove(curNode);
                path.remove(path.get(path.size()-1));
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return path;
    }
}
