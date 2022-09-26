package 剑指offer;


//https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
public class _53_II_0到n减1中缺失的数字 {

    /**
     * 二分法查找，如果nums[mid] == mid，说明缺失的数字在mid右边，否则在左边
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == mid) i = mid + 1;
            else j = mid - 1;
        }

        return i;
    }
}
