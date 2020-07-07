package 剑指offer;


import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
public class _37_序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null){
                builder.append("null,");
            }else {
                builder.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        if (data==null || data.length()==0) return null;
        String[] values = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!values[i].equals("null")){
                node.left =new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            if (!values[i].equals("null")){
                node.right =new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;

        }
        return root;
    }
}
