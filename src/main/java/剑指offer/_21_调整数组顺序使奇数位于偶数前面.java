package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-13 12:33
 */

//https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/submissions/
public class _21_调整数组顺序使奇数位于偶数前面 {

    /**
     * 双指针问题，一个指针指向偶数，另一个指向奇数，向中间移动
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums==null || nums.length==0 || nums.length==1) return nums;
        int i = 0;
        int j = nums.length - 1;
        int t = 0;
        while (true){
            while (i<nums.length && nums[i]%2==1) i++;
            while (j>=0 && nums[j]%2==0) j--;
            if (i>=j) return nums;
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
