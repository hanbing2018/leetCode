package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-13 17:26
 */

//https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
public class _27_二叉树的镜像 {

    /**
     * 递归翻转左子树和右子树即可
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);
        return newRoot;
    }
}
