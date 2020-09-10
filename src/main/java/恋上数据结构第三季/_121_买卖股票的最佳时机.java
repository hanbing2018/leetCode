package 恋上数据结构第三季;



//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
public class _121_买卖股票的最佳时机 {

    /**
     * 方法一：遍历数组。
     * 从第二天开始遍历，计算当天卖股票获得的最大利润，即计算出每一天卖出能获得的最大利润；最后取最大值即可。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 前面扫描过的最小价格
        int minPrice = prices[0];
        // 前面扫描过的最大利润
        int maxProfit = 0;
        // 扫描所有的价格
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else { // 把第i天的股票卖出
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    //方法二：动态规划
    //先得出相邻两天的股票差值，再连续子数组的最大和
}
