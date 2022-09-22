package 数组和串;


import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/subsets/
public class _78_子集 {
    /**
     * dfs。有N个数的子集，即从原数组中取N个数组成子集，可以用dfs
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());

        if (nums == null || nums.length == 0) return res;

        //i表示从数组中取几个值组成子数组
        for (int i = 1; i <= nums.length; i++) {
            subsetCore(nums, res, i, 0, new LinkedList<>());
        }
        return res;
    }

    private void subsetCore(int[] nums, List<List<Integer>> res, int i, int index, LinkedList<Integer> list) {
        if (i == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if (index >= nums.length) {
            return;
        }

        //深度优先搜索
        for (int j = index; j < nums.length; j++) {
            list.add(nums[j]);
            subsetCore(nums, res, i - 1, j + 1, list);
            //注意恢复现场
            list.removeLast();
        }

    }
}
