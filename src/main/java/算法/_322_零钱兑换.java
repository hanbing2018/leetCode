package 算法;


import java.util.Arrays;

//https://leetcode-cn.com/problems/coin-change/
public class _322_零钱兑换 {

    /**
     * 用动态规划dp，依次求出amount为1,2,3.。。的结果
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //将初始值设为比较大的值
        Arrays.fill(dp, amount+1);
        //边界条件
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i>=coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[amount]==(amount+1)) return -1;
        return dp[amount];
    }
}
