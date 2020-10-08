package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-09 16:34
 */

//https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
public class HARD_19_正则表达式匹配 {
    public boolean isMatch(String s, String p) {

        /**
         * 此题难度 难
         */

        //动态规划算法
        if (s == null || p == null) return false;
        int slen = s.length();
        int plen = p.length();
        //match[i][j]表示s前i个字符与p前j个字符是否匹配
        boolean[][] match = new boolean[slen + 1][plen + 1];

        //初始化条件
        match[0][0] = true; //空字符串和空字符串是匹配的
        //判断s为空时p能否匹配空
        for (int i = 2; i <= plen; i = i + 2) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match[i][j] = match[i][j - 2]) continue;
                    //如果s当前的字符与p的当前的*的前一个字符匹配
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        match[i][j] = match[i - 1][j];
                    }

                } else {
                    //如果s[i-1]与p[j-1]匹配
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        match[i][j] = match[i - 1][j - 1];
                    }
                }
            }

        }
        return match[slen][plen];
    }
}
