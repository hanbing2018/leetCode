package 剑指offer;

import java.util.Stack;

/**
 * @author hanbing
 * @create 2020-04-16 15:58
 */

//https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
public class _31_栈的压入与弹出序列 {

    /**
     * 遍历pop数组，利用一个stack来检查
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            //如果stack为空或栈顶不是pop数组当前的数值，则将当前push数组的值圧栈
            while (stack.isEmpty() || stack.peek() != popped[i]) {
                //圧栈之前判断是否还有数值可以入栈，没有值可入栈则返回false
                if (j == pushed.length) return false;
                stack.push(pushed[j++]);
            }
            stack.pop();
        }
        return true;
    }
}
