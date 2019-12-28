package 二叉树;

import javax.xml.soap.Node;

/**
 * @author hanbing
 * @date 2019-12-28 19:32
 */

//https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return sortA(nums, 0, len-1);
    }

    private TreeNode sortA(int[] nums, int start, int end) {
        if (start==end) return new TreeNode(nums[start]);
        if (start>end) return null;

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortA(nums, start, mid-1);
        root.right = sortA(nums, mid+1, end);
        return root;
    }
}
