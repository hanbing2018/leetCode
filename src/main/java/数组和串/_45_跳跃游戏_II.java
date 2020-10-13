package 数组和串;


import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/jump-game-ii/
public class _45_跳跃游戏_II {

    /**
     * 动态规划。从第一步开始，依次得出下一步能到达的最远位置。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        //map存储key步可以跳到的最远的位置(索引)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, nums[0]);
        int k = 1;
        while (true) {
            //map.get(k)是k步能到达的最远位置(索引)
            if (map.get(k) >= nums.length - 1) return k;

            int max = 0;
            //从k开始，因为走k步最少也到达k的位置
            for (int i = k; i <= map.get(k); i++) {
                max = Math.max(max, nums[i] + i);
            }
            map.put(++k, max);
        }
    }
}
