package 恋上数据结构第三季;

/**
 * @author hanbing
 * @date 2020-10-14 21:21
 */

//https://leetcode-cn.com/problems/move-zeroes/
public class _283_移动零 {

    /**
     * 类似于冒泡排序法
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // l始终指向从左数第一个0
        int l = 0;
        while (l < nums.length) {
            if (nums[l] != 0) {
                l++;
            } else break;
        }
        //如果没有零，直接返回
        if (l == nums.length) return;
        int r = l + 1;
        while (r < nums.length) {
            if (nums[r] == 0) {
                r++;
                continue;
            }
            nums[l] = nums[r];
            nums[r] = 0;
            l++;
            r++;
        }
    }
}
