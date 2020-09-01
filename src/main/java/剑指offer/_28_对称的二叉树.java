package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-13 18:28
 */

//https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
public class _28_对称的二叉树 {

    /**
     * 方法一：递归
     *递归判断左右两个子树是否相等即可
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true; //此题中规定root为null时为对称的
        return isTwoTreeSymmetric(root.left, root.right);
    }


    //判断两个二叉树是否对称
    private boolean isTwoTreeSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;  //其中一个为null，则肯定不对称

        if (left.val!= right.val) return false;  //根节点的值不一样，则不对称
        return isTwoTreeSymmetric(left.left, right.right) && isTwoTreeSymmetric(left.right, right.left);
    }


    //方法二：迭代（非递归）
}
