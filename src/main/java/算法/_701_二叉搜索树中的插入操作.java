package 算法;

//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
public class _701_二叉搜索树中的插入操作 {

    /**
     * 从root节点开始找，判断值和当前节点大小关系和当前节点的左右子节点的存在情况确定要加入的位置
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode t = root;
        while (true) {
            if (val < t.val) {
                if (t.left == null) {
                    t.left = new TreeNode(val);
                    break;
                } else {
                    t = t.left;
                }
            }

            if (val > t.val) {
                if (t.right == null) {
                    t.right = new TreeNode(val);
                    break;
                } else {
                    t = t.right;
                }
            }

        }

        return root;
    }
}
