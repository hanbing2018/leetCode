package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-29 21:44
 */

//https://leetcode-cn.com/problems/balanced-binary-tree/
public class _110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        int leftH = hight(root.left);
        int leftR = hight(root.right);

        if (Math.abs(leftH - leftR) > 1) return false;

        return isBalanced(root.left)&&isBalanced(root.right);
    }


    //计算节点的高度
    private int hight(TreeNode node) {
        if (node==null) return 0;
        return 1 + Math.max(hight(node.left), hight(node.right));
    }
}
