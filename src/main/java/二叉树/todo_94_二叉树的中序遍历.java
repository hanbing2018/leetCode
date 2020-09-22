package 二叉树;

import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class todo_94_二叉树的中序遍历 {

    /**
     * 非递归的方式实现二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        todo_94_二叉树的中序遍历 ob = new todo_94_二叉树的中序遍历();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = ob.inorderTraversal(root);
        System.out.println(list);
    }
}
