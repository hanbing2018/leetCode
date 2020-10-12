package 数组和串;

/**
 * @author hanbing
 * @date 2020-10-01 20:21
 */

//https://leetcode-cn.com/problems/house-robber/
public class _198_打家劫舍 {


    /**
     * 方法一：动态规划。从右向左依次计算最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        //res[i]表示nums[i]到nums[len-1]范围内的最大值
        int[] res = new int[len];
        res[len - 1] = nums[len - 1];
        res[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
        for (int i = len - 3; i >= 0; i--) {
            res[i] = Math.max(nums[i] + res[i + 2], res[i + 1]);
        }

        return res[0];
    }


    /**
     * 方法二：递归。此方法超出时间限制
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return robCore(nums, 0);
    }

    private int robCore(int[] nums, int start) {
        if (start == nums.length - 1) return nums[nums.length - 1];
        if (start > nums.length - 1) return 0;

        return Math.max(robCore(nums, start + 1), nums[start] + robCore(nums, start + 2));
    }
}
