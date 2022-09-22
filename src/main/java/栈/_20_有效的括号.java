package 栈;

import java.util.Stack;

//https://leetcode-cn.com/problems/valid-parentheses/
public class _20_有效的括号 {
    /**
     * 用一个栈，元素压入栈，配对则pop，最后判断栈是否为空
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        char[] chars = s.toCharArray();
        //如果有奇数个字符，返回true
        if ((chars.length & 1) == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || !bEqual(stack, chars[i])) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    //判断新元素与栈顶元素是否配对
    private boolean bEqual(Stack<Character> stack, char aChar) {
        if (stack.peek().equals('(') && aChar == ')') return true;
        if (stack.peek().equals('[') && aChar == ']') return true;
        if (stack.peek().equals('{') && aChar == '}') return true;
        return false;
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('c');
        System.out.println(stack.peek().equals('c'));
    }
}
