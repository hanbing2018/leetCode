package 二叉树;

/**
 * @author hanbing
 * @date 2019-12-28 19:32
 */

//https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
public class _108_将有序数组转换为二叉搜索树 {

    /**
     * 递归，每次选取中间位置的值作为root节点val，选左边中间位置的值作为左子节点的val，右边中间位置的值作为右子节点的val
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return sortCore(nums, 0, len - 1);
    }

    private TreeNode sortCore(int[] nums, int start, int end) {
        if (start == end) return new TreeNode(nums[start]);
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortCore(nums, start, mid - 1);
        root.right = sortCore(nums, mid + 1, end);
        return root;
    }
}
