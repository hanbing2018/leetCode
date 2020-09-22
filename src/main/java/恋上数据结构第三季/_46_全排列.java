package 恋上数据结构第三季;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanbing
 * @date 2020-07-26 22:58
 */


//https://leetcode-cn.com/problems/permutations/
public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) return lists;

        int[] result = new int[nums.length];
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used, lists, result);
        return lists;
    }

    private void dfs(int[] nums, int idx, boolean[] used, List<List<Integer>> lists, int[] result) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : result) {
                list.add(i);
            }
            lists.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            result[idx] = nums[i];
            used[i] = true;
            dfs(nums, idx + 1, used, lists, result);
            used[i] = false;
        }
    }
}
