package 剑指offer;

/**
 * @author hanbing
 * @date 2020-04-01 21:21
 */

//https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
public class _03_数组中重复的数字 {
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

    public static void main(String[] args) {
        _03_数组中重复的数字 d = new _03_数组中重复的数字();
        d.findRepeatNumber(new int[]{2,3,1,0,2,5,3});
    }
}
