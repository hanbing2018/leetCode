package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-28 17:32
 */


//https://leetcode-cn.com/problems/search-in-a-binary-search-tree/submissions/
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        if (node==null) return null;

        while (node!=null){
            if (val>node.val) {
                node = node.right;
                continue;
            }
            if (val<node.val) {
                node = node.left;
                continue;
            }
            if (val==node.val) return node;
        }

        return node;
    }
}
