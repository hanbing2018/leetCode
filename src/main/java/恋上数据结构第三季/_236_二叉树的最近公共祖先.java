package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class _236_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;

        return left == null ? right : left;
    }
}
