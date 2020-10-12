package 恋上数据结构第三季;


import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses/
public class _22_括号生成 {

    /**
     * dfs。依次判断下一层的符号可以选择哪个
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n < 0) return null;
        List<String> res = new LinkedList<>();
        if (n == 0) {
            res.add("");
            return res;
        }

        dfs(n, 0, n, n, res, new char[n << 1]);

        return res;
    }

    private void dfs(int n, int index, int leftRemain, int rightRemain, List<String> res, char[] chars) {
        if (index == n << 1) {
            res.add(new String(chars));
        }

        if (leftRemain > 0) {
            chars[index] = '(';
            dfs(n, index + 1, leftRemain - 1, rightRemain, res, chars);
        }

        if (rightRemain > 0 && leftRemain != rightRemain) {
            chars[index] = ')';
            dfs(n, index + 1, leftRemain, rightRemain - 1, res, chars);
        }
    }
}
