package 剑指offer;


//https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
public class _39_数组中出现次数超过一半的数字 {

    /**
     * 方法一：摩尔投票法，是本题的最佳解法，空间复杂度O(1)，时间复杂度O(n)。不具有普适性
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int vote = 0;
        int x = nums[0];
        for (int num : nums) {
            if (vote == 0) x = num;
            vote += (x == num ? 1 : -1);
        }
        return x;
    }

    /**
     * 方法二：map存储数字为key，次数为val。二次遍历寻找val大于nums/2的key。
     * 时间复杂度和空间复杂度都是O(n)
     */
}
