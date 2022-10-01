package 算法;


//https://leetcode-cn.com/problems/decode-ways/
public class _91_解码方法 {

    /**
     * 典型的动态规划算法。这个题目很坑，要处理非常复杂的边界情况，知道算法思路即可，不必AC。
     * 以下是假设至少有一种解码方式，没有前导0的情况
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        //dp[i]表示以chars[i]为结尾的字符串能够解码的方式数量
        int[] dp = new int[chars.length];

        if (chars.length == 1) return 1;
        dp[0] = 1;
        if (chars[1] == '0') {
            dp[1] = 1;
        } else if (chars[0] == '1' || (chars[0] == '2' && chars[1] <= '6')) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == '0') {
                dp[i] = dp[i - 2];
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[1] <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (chars[i - 1] == '0') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[chars.length - 1];
    }
}
