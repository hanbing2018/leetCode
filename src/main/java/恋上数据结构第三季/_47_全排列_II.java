package 恋上数据结构第三季;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hanbing
 * @date 2020-10-02 22:38
 */

//https://leetcode-cn.com/problems/permutations-ii/
public class _47_全排列_II {

    /**
     * dfs。注意先对数组进行排序，dfs时注意是否需要剪枝
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) {
            res.add(new LinkedList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> chars = new LinkedList<>();
        dfs(nums, 0, used, res, chars);
        return res;
    }

    private void dfs(int[] nums, int index, boolean[] used, List<List<Integer>> res, List<Integer> chars) {
        if (index == nums.length) {
            res.add(new LinkedList<>(chars));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            chars.add(nums[i]);
            used[i] = true;
            dfs(nums, index + 1, used, res, chars);
            chars.remove(chars.size() - 1);
            used[i] = false;
        }
    }
}
