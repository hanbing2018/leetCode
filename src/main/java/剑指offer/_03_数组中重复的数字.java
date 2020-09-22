package 剑指offer;

/**
 * @author hanbing
 * @date 2020-04-01 21:21
 */

//https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
public class _03_数组中重复的数字 {

    /**
     * 方法一：此方法为书中的方法，不具有普适性。时间复杂度O(n),空间复杂度O(1)，会改变原始数组。
     * 因为长度为n的数组数字范围为0-n-1，所以从index=0开始遍历。nums[i]==i(数值等于下标)则继续，不相等则
     * 判断nums[i] == nums[nums[i]]，为true则找到了一个重复数字。为false则交换值nums[i]与nums[nums[i]]，使得nums[nums[i]]数值等于下标。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        int t = 0;
        while (i < nums.length) {
            if (i == nums[i]){
                i++;
            }else {
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }else {
                    t = nums[i];
                    nums[i] = nums[t];
                    nums[t] = t;
                }
            }
        }
        return -1;
    }

    /**
     * 方法二：利用hashmap依次加入map中并contains比较。具有普适性，时间复杂度O(n),空间复杂度O(n)，不会改变原始数组。
     * @param args
     */

    public static void main(String[] args) {
        _03_数组中重复的数字 d = new _03_数组中重复的数字();
        d.findRepeatNumber(new int[]{2,3,1,0,2,5,3});
    }
}
