package 剑指offer;


//https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
public class _57_和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length<=1) return new  int[2];

        int i = 0;
        int j = nums.length - 1;
        int sum;
        while (i<j){
            sum = nums[i] + nums[j];
            if (sum==target) return new int[]{nums[i], nums[j]};
            if (sum > target) {
                j--;
                continue;
            }
            if (sum < target) {
                i++;
                continue;
            }
        }

        return new int[2];
    }
}
