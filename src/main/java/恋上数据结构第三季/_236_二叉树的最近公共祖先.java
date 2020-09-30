package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class _236_二叉树的最近公共祖先 {

    /**
     * 递归。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root为null，返回null;如果p或q为root，则root为最近公共祖先
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果left不为null且right也不为null，则必定left等于p、q中的一个，right等于另一个，此时root为最近公共祖先
        if (left != null && right != null) return root;
        //如果right为null，则left必定等于p或q此时left为最近公共祖先
        return left == null ? right : left;
    }
}
