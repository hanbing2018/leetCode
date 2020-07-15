package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/longest-palindromic-substring/
public class _5_最长回文子串 {

    //本题是经典面试题！有多种优秀的方法
    //方法一：动态规划
    public String longestPalindromeDp(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        // 最长回文子串的长度（至少是1）
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        boolean[][] dp = new boolean[cs.length][cs.length];
        // 从下到上（i由大到小）
        for (int i = cs.length - 1; i >= 0; i--) {
            // 从左到右（j由小到大）
            for (int j = i; j < cs.length; j++) {
                // cs[i, j]的长度
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) { // 说明cs[i, j]是回文子串
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }

    //方法二：
}
