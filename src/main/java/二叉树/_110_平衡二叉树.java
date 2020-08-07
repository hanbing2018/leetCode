package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-29 21:44
 */

//https://leetcode-cn.com/problems/balanced-binary-tree/
public class _110_平衡二叉树 {

    /**
     * 递归算法；
     *      1. 编写函数，递归算出以某节点为根节点的树的高度
     *      2. 递归判断根节点左右子树高度差是否小于1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        int leftH = hight(root.left);
        int leftR = hight(root.right);

        if (Math.abs(leftH - leftR) > 1) return false;

        return isBalanced(root.left)&&isBalanced(root.right);
    }


    //计算以该节点为root的树的高度
    private int hight(TreeNode node) {
        if (node==null) return 0;
        return 1 + Math.max(hight(node.left), hight(node.right));
    }
}
