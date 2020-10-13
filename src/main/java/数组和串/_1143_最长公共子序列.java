package 数组和串;

/**
 * @author hanbing
 * @date 2020-10-12 23:02
 */

//https://leetcode-cn.com/problems/longest-common-subsequence/
public class _1143_最长公共子序列 {

    /**
     * dp
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //假设dp(i, j)是nums1前i个元素与nums2前j个元素的最长公共子序列长度

        char[] chs1 = text1.toCharArray();
        char[] chs2 = text2.toCharArray();

        int[][] dp = new int[chs1.length + 1][chs2.length + 1];
        //dp[i][0]=dp[0][j]=0 i>=0,j>=0
        //如果 chs1[i–1]=chs2[j–1]，那么dp(i, j)=dp(i–1, j–1) + 1
        //如果 chs1[i–1]≠chs2[j–1]，那么dp(i, j)=max{dp(i–1, j),dp(i, j–1)}
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }
}
