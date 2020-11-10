package 数组和串;

import java.util.Arrays;

//https://leetcode-cn.com/problems/next-permutation/
public class _31_下一个排列 {

    /**
     * 两遍排序，替换逆序对后将后半部分排序
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        //第一遍排序，寻找从右到左第一个逆序对
        int indexL = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                indexL = i;
                break;
            }
        }
        //如果无逆序对
        if (indexL == -1) {
            Arrays.sort(nums);
            return;
        }
        //第二遍排序，寻找比nums[indexL]大的数
        int indexR = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[indexL]) {
                indexR = i;
                break;
            }
        }
        int t = nums[indexL];
        nums[indexL] = nums[indexR];
        nums[indexR] = t;
        int l = indexL + 1;
        int r = nums.length - 1;
        while (l < r) {
            int tem = nums[l];
            nums[l] = nums[r];
            nums[r] = tem;
            l++;
            r--;
        }
    }
}
