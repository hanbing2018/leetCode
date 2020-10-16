package 算法;


import java.util.List;

//https://leetcode-cn.com/problems/word-break/
public class _139_单词拆分 {
    /**
     * 动态规划算法，dp[i]表示s前i个字符能否拆分
     * 转移方程：dp[j] = dp[i] && check(s[i+1, j]);
     * check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
     * 其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
     * 这个举个例子就很容易理解。
     * 假如wordDict=["apple", "pen", "code"],s = "applepencode";
     * dp[8] = dp[5] + check("pen")
     * 翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
     * （注意：i的顺序是从j-1 -> 0)
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
