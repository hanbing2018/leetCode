package 剑指offer;

import java.util.Stack;

/**
 * @author hanbing
 * @create 2020-04-16 15:58
 */

//https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
public class _31_栈的压入与弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            while (stack.isEmpty() || stack.peek() != popped[i]) {
                if (j == pushed.length) return false;
                stack.push(pushed[j++]);
            }
            stack.pop();
        }
        return true;
    }
}
