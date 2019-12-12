package 栈;

/**
 * @author hanbing
 * @create 2019-12-11 14:17
 */


//https://leetcode-cn.com/problems/score-of-parentheses/
public class _856_括号的分数 {
    public int scoreOfParentheses(String S) {
        int left = 0;
        int ans = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == '('){
                left++;
            }else {
                left--;
                if (S.charAt(i-1) == 'C')
                ans += (1>>left);
            }
        }
        return ans;
    }
}
