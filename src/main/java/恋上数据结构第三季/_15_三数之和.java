package 恋上数据结构第三季;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanbing
 * @date 2020-07-31 19:55
 */


//https://leetcode-cn.com/problems/3sum/
public class _15_三数之和 {

    /**
     * 用三指针完成遍历。
     * 关键点：1，对数组进行排序。2，去重。
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        // 排序
        Arrays.sort(nums);

        // i用来扫描三元组的第一个元素
        int lastIdx = nums.length - 3;
        int lastR = nums.length - 1;
        for (int i = 0; i <= lastIdx; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = lastR, remain = -nums[i];
            while (l < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) { // 找到了符合条件的三元组
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过相同的值（去重）
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    // 往中间逼近
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else { // sumLr > remain
                    r--;
                }
            }
        }
        return res;
    }
}
