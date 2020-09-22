package 剑指offer;


//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
public class _53_I_在排序数组中查找数字I {


    //见LeetCode排名第一解析
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid;

        while (i <= j) {
            mid = i + (j - i) / 2;

            if (nums[mid] <= target) i = mid + 1;
            else j = mid - 1;
        }
        int r = i;


        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            mid = i + (j - i) / 2;

            if (nums[mid] >= target) j = mid - 1;
            else i = mid + 1;
        }
        int l = j;

        return r - l - 1;
    }
}
