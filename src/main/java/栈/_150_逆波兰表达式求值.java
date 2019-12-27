package 栈;

import java.rmi.Remote;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2019-12-27 11:04
 */


//https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        int res = 0;

        Stack<Integer> stack = new Stack<Integer>();

        int len = tokens.length;
        if (len ==1){
            return Integer.parseInt(tokens[0]);
        }
        int tem1;
        int tem2;
        String tems;
        for (int i=0; i<len; i++){
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
            stack.push(Integer.parseInt(tems));
        }
        return res;
    }
}
