package 剑指offer;


//https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
public class _42_连续子数组的最大和 {

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
