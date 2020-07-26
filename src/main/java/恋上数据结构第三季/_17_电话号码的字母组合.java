package 恋上数据结构第三季;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hanbing
 * @date 2020-07-26 21:12
 */


//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
public class _17_电话号码的字母组合 {

    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if(digits == null) return null;
        char[] chars = digits.toCharArray();
        List<String> list = new LinkedList<>();
        if (chars.length==0) return list;

        char[] strChars = new char[chars.length];

        dfs(chars, 0, list, strChars);

        return list;
    }

    private void dfs(char[] chars, int idx, List<String> list, char[] strChars) {
        if (idx==chars.length){
            list.add(new String(strChars));
            return;
        }

        for (char c :lettersArray[chars[idx] - '2']){
            strChars[idx] = c;
            dfs(chars, idx+1, list, strChars);
        }

    }
}
