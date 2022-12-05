package 数组和串;

import java.util.Stack;

/**
 * @author hanbing
 * @date 2022-12-06 1:31
 */


// https://leetcode.cn/problems/simplify-path/
public class _71_简化路径 {

    public String simplifyPath(String path) {
        char[] chars = new char[path.length()];

        // 去除重复的'/'
        int k = 0;
        for (int i = 0; i < path.length(); i++) {
            while (i + 1 < path.length() && path.charAt(i) == '/' && path.charAt(i + 1) == '/') i++;
            chars[k++] = path.charAt(i);
        }

        // 去除最后的'/'
        if (chars[k - 1] == '/') k--;

        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < k) {
            int j = i + 1;
            while (j < k && chars[j] != '/') j++;

            //  如果是'/.'，略过
            if (j - i == 2 && i + 1 < k && chars[i + 1] == '.') {
                i = j;
                continue;
            }

            // 如果是'/..'，抛出栈顶元素(前一个路径)
            if (j - i == 3 && i + 2 < k && chars[i + 1] == '.' && chars[i + 2] == '.') {
                if (!stack.isEmpty()) stack.pop();
                i = j;
                continue;
            }

            // 将本阶段的路径加入到栈中
            stack.push(new String(chars, i, j - i));
            i = j;
        }

        if (stack.isEmpty()) return "/";
        String res = "";
        int size = stack.size();
        for (int j = 0; j < size; j++) {
            res = stack.pop() + res;
        }

        return res;
    }
}
