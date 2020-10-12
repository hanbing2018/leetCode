package 算法;

/**
 * @author hanbing
 * @date 2020-10-12 20:45
 */
public class _最长公共子串 {

    //求两个字符串的最长公共子串的长度。如 abced ceaa的最长公共子串是ce
    //注意 子串 和 子序列 的区别，子串是连续的，子序列可以不连续

    /**
     * dp
     *
     * @param s1
     * @param s2
     * @return
     */
    public int longestSubStr(String s1, String s2) {
        //dp(i,j)是以s1[i-1]、s2[j-1]结尾的最长公共子串的长度，i>=1, j>=1
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] dp = new int[chs1.length + 1][chs2.length + 1];
        //dp[0][0]=0; dp[i][0]=dp[0][j]=0, 1<=i<=s1.length, 1<=j<=s2.length
        int res = 0;
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
