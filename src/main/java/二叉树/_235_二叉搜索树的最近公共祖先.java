package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-28 20:15
 */

//https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/javadi-gui-san-xing-dai-ma-by-get996/


    /*
    三行代码
    根结点比两个结点都大 就在左子树找
    根结点比两个结点都小 就在右子树找
    否则就返回根结点
     */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
