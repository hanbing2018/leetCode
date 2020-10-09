package 剑指offer;


//https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
public class _42_连续子数组的最大和 {

    /**
     * 用sum记录连续子序列的和，如果为负，则忽略这一串子序列，以下一元素为子序列头进行相加
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum <= 0) {
                sum = 0;
            }
        }

        return max;
    }
}
