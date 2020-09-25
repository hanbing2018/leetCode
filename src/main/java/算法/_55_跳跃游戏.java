package 算法;

//https://leetcode-cn.com/problems/jump-game/
public class _55_跳跃游戏 {

    /**
     * 依次判断当前位置是否可达，并更新能到达的最大位置
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        // maxIndex表示能到达最大位置的索引
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前位置不能到达，返回false
            if (maxIndex < i) return false;
            //更新能到达的最大位置
            maxIndex = Math.max(maxIndex, i + nums[i]);
            //如果更新后能到达最大位置，则fanhuitrue，不必再循环
            if (maxIndex >= nums.length - 1) return true;
        }

        return true;
    }
}
