package 算法;

/**
 * @author hanbing
 * @date 2020-10-12 21:54
 */
public class _01背包问题 {

    // 背包总可装capacity重量的东西，知道n个东西的重量和价值，求背包能装的最大的总价值

    /**
     * dp
     *
     * @param capacity
     * @param weights
     * @param values
     * @return
     */
    public int maxVal(int capacity, int[] weights, int[] values) {
        //dp[i][j]是最大承重为j、有前i个物品可选的总最大值  0<=i<=n 0<=j<=catacity
        //初始值 dp[i][0]=0(称重为0) dp[0][j]=0(无东西可选)
        //如果 j< weights[i– 1] ，那么 dp(i, j) = dp(i– 1, j)
        //如果 j≥ weights[i– 1] ，那么 dp(i, j) = max {dp(i– 1, j), dp(i– 1, j–weights[ i– 1]) + values[i-1])}
        if (weights == null || weights.length == 0) return 0;
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[values.length][capacity];
    }


    /**
     * 如果求正好装capacity的最大总价值?
     * 还是dp算法
     *
     * @param capacity
     * @param weights
     * @param values
     * @return
     */
    public int maxVal2(int capacity, int[] weights, int[] values) {
        //dp[i][j]是承重恰好为j、有前i个物品可选的总最大值  0<=i<=n 0<=j<=catacity
        //初始值 dp[i][0]=0(称重为0) i>=0;dp[0][j]=负无穷 j>=1
        //如果 j< weights[i– 1] ，那么 dp(i, j) = dp(i– 1, j)
        //如果 j≥ weights[i– 1] ，那么 dp(i, j) = max {dp(i– 1, j), dp(i– 1, j–weights[ i– 1]) + values[i-1])}
        if (weights == null || weights.length == 0) return 0;
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int j = 1; j <= capacity; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[values.length][capacity] < 0 ? -1 : dp[values.length][capacity];
    }
}