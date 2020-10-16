package 栈;

/**
 * @author hanbing
 * @create 2019-12-11 14:17
 */


//https://leetcode-cn.com/problems/score-of-parentheses/
public class _856_括号的分数 {

    /*
    思路：实际只有嵌在内部的”()”贡献分数。其它的'(‘用来乘以2。在 “()” 的外面包裹着多少个'(‘就乘以几个2.

    例如： “(()(()))”
    第一个”()”，外面有1个'(‘， “(()(()))” ，分值为2;
    第二个”()”，外面有2个'(‘， “(()(()))” ，分值为4;
     */
    public int scoreOfParentheses(String S) {
        int left = 0;
        int ans = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                left--;
                if (S.charAt(i - 1) == '(')
                    ans += (1 << left);
            }
        }
        return ans;
    }
}
