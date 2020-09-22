package 栈;

import java.util.Stack;

/**
 * @author hanbing
 * @date 2019-12-27 11:04
 */


//https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class _150_逆波兰表达式求值 {

    /**
     * 用一个栈实现，遇到数字就放入栈中;遇到运算符就拿出两个数进行计算，将计算结果再放入栈中
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int res = 0;

        Stack<Integer> stack = new Stack<Integer>();

        int len = tokens.length;
        if (len == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int tem1;
        int tem2;
        String tems;
        for (int i = 0; i < len; i++) {
            tems = tokens[i];
            if (tems.equals("+")) {
                tem2 = stack.pop();
                tem1 = stack.pop();
                res = tem1 + tem2;
                stack.push(res);
                continue;
            }
            if (tems.equals("-")) {
                tem2 = stack.pop();
                tem1 = stack.pop();
                res = tem1 - tem2;
                stack.push(res);
                continue;
            }
            if (tems.equals("*")) {
                tem2 = stack.pop();
                tem1 = stack.pop();
                res = tem1 * tem2;
                stack.push(res);
                continue;
            }
            if (tems.equals("/")) {
                tem2 = stack.pop();
                tem1 = stack.pop();
                res = tem1 / tem2;
                stack.push(res);
                continue;
            }
            //如果是数字则直接放入栈中
            stack.push(Integer.parseInt(tems));
        }
        return res;
    }
}
