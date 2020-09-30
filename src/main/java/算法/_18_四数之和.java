package 算法;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/4sum/
public class _18_四数之和 {
    int[] nums;

    /**
     * 本题的解法是利用一个通用的nSum函数，四数之和是n=4的特例
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        Arrays.sort(this.nums);
        return nSum(0, target, 2);
    }

    /**
     * 一个通用的函数，计算n个数的和为target的情况，数组排序是前提
     *
     * @param start
     * @param target
     * @param count
     * @return
     */
    private List<List<Integer>> nSum(int start, int target, int count) {
        int length = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        //至少是2Sum，数组大小不应该小于count
        if (count < 2 || length < count) return result;
        //如果是两个数相加，用双指针法直接计算
        if (count == 2) {
            int left = start;
            int right = length - 1;
            while (left < right) {
                int l = nums[left];
                int r = nums[right];
                int sum = l + r;
                if (sum < target) {
                    while (left < right && nums[left] == l) left++;
                } else if (sum > target) {
                    while (left < right && nums[right] == r) right--;
                } else {
                    List<Integer> t = new LinkedList<>();
                    t.add(l);
                    t.add(r);
                    result.add(t);
                    while (left < right && nums[left] == l) left++;
                    while (left < right && nums[right] == r) right--;
                }
            }
        } else {
            //n>2，递归计算(n-1)Sum的结果
            for (int i = start; i < length; i++) {
                List<List<Integer>> lists = nSum(i + 1, target - nums[i], count - 1);
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return result;
    }
}
