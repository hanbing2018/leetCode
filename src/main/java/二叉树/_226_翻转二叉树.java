package 二叉树;


/**
 * @author hanbing
 * @create 2019-12-17 9:22
 */

//https://leetcode-cn.com/problems/invert-binary-tree/submissions/
public class _226_翻转二叉树 {

    /**
     * 利用递归即可，简单题目
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode newLeft = root.left;
        TreeNode newRight = root.right;
        root.left = invertTree(newRight);
        root.right = invertTree(newLeft);

        return root;
    }
}
