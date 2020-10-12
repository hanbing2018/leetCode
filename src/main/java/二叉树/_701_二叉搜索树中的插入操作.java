package 二叉树;


/**
 * @author hanbing
 * @date 2019-12-28 17:36
 */

//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/submissions/
public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode node = root;
        if (node == null) {  //空树
            return newNode;
        }

        TreeNode pa = node;
        int com = 0;
        while (node != null) {
            pa = node;
            if (val > node.val) {
                com = 1;
                node = node.right;
                continue;
            }
            if (val < node.val) {
                com = -1;
                node = node.left;
                continue;
            }
            if (val == node.val) return root;
        }

        if (com > 0) {
            pa.right = newNode;
            return root;
        }
        if (com < 0) {
            pa.left = newNode;
            return root;
        }

        return root;
    }
}
