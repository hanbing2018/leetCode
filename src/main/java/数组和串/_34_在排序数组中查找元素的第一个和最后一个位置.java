package 数组和串;

//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 参考 剑指offer 53_I，分别求出target左边第一个比它小的数的索引和右边第一个比它大的数的索引
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //找到target右边第一个比它大的数
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        int ridx = l;

        l = 0;
        r = nums.length - 1;
        //找到target左边第一个比它小的数
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        int lidx = r;
        if (ridx - lidx - 1 <= 0) return new int[]{-1, -1};
        return new int[]{lidx + 1, ridx - 1};
    }
}
