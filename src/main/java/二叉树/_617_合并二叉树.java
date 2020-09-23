package 二叉树;


//https://leetcode-cn.com/problems/merge-two-binary-trees/
public class _617_合并二叉树 {

    /**
     * 用递归实现
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            if (t2 == null) return null;
            else return t2;
        } else {
            if (t2 == null) return t1;
        }
        // t1!=null && t2!=null
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
