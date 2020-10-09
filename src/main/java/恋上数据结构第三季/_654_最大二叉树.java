package 恋上数据结构第三季;

/**
 * @author hanbing
 * @date 2020-10-02 0:27
 */

//https://leetcode-cn.com/problems/maximum-binary-tree/
public class _654_最大二叉树 {

    /**
     * 递归。求出根节点再递归求出左右子树的根节点
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return findRoot(nums, 0, nums.length - 1);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {
        if (r < l) return null;

        int maxIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = findRoot(nums, l, maxIndex - 1);
        root.right = findRoot(nums, maxIndex + 1, r);
        return root;
    }
}
