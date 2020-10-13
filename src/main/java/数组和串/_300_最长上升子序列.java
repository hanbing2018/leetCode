package 数组和串;

/**
 * @author hanbing
 * @date 2020-10-12 20:30
 */

//https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class _300_最长上升子序列 {

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //dp[i]代表以num[i]为结尾的最大上升序列长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
