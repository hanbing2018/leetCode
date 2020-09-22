package 算法;

//https://leetcode-cn.com/problems/trapping-rain-water/
public class _42_接雨水 {

    /**
     * 方法一：是方法二的加强版，空间复杂度由O(n)减少为O(1)
     * 双指针解法。判断当前值左边最大值和右边最大值中的较小值，减去本身数值即为本值所在雨水量。
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int ans = 0;
        int left = 1;
        int right = height.length - 2;
        int lmax = height[0];
        int rmax = height[right + 1];
        while (left <= right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if (lmax <= rmax) {
                ans += (lmax - height[left]);
                left++;
            } else {
                ans += (rmax - height[right]);
                right--;
            }
        }

        return ans;
    }

    /**
     * 方法二：在暴力访问的基础上增加备忘录优化的算法
     *
     * @param height
     * @return
     */
    int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int ans = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            ans += Math.min(l_max[i], r_max[i]) - height[i];
        return ans;
    }
}
