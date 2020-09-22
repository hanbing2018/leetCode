package 栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2019-12-27 11:30
 */

//https://leetcode-cn.com/problems/basic-calculator/
public class _224_基本计算器 {

    /**
     * 方法一：利用两个栈实现，详细见注释
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        Stack<String> stackSimp = new Stack<String>();
        String tems;

        int len = s.length();
        for (int i = 0; i < len; i++) {  //循环遍历字符串的每一个字符
            tems = s.substring(i, i + 1);
            if (tems.equals(" ")) {  //如果是空格，跳过
                continue;
            }
            if (tems.equals("(")) { //如果是左括号，加入到栈stack中
                stack.push(tems);
                continue;
            }
            if (tems.equals(")")) {  //如果是右括号，则计算此右括号到左括号的表达式的值
                String temm;
                while (!(temm = stack.pop()).equals("(")) {  //将括号内的表达式放入栈stackSimp中
                    stackSimp.push(temm);
                }
                //将计算结果放入到stack中，此时已经去掉了一对括号
                stack.push(String.valueOf(calculateSimple(stackSimp)));
                continue;
            }
            if (tems.equals("+") || tems.equals("-")) {  //如果是运算符，加入栈中
                stack.push(tems);
                continue;
            }

            //如果是数值，则加入到栈中
            int sum = Integer.parseInt(tems);
            //数值可能不是个位数，比如332，必须把这几个字符转化为一个数字字符串放入stack中
            while ((i + 1) < len && Character.isDigit(s.charAt(i + 1))) {
                i++;
                sum = sum * 10 + Integer.parseInt(s.substring(i, i + 1));
            }
            stack.push(String.valueOf(sum));
        }

        //此时已经没有括号了，直接计算最终的值
        while (!stack.isEmpty()) {
            stackSimp.push(stack.pop());
        }

        return calculateSimple(stackSimp);
    }

    //计算一个没有括号的计算式的值
    public int calculateSimple(Stack<String> st) {
        String tem1;
        String temf;
        String tem2;
        while (true) {
            if (st.size() == 1) break;

            tem1 = st.pop();
            temf = st.pop();
            tem2 = st.pop();
            if (temf.equals("+")) {
                st.push(String.valueOf(Integer.parseInt(tem1) + Integer.parseInt(tem2)));
                continue;
            }
            if (temf.equals("-")) {
                st.push(String.valueOf(Integer.parseInt(tem1) - Integer.parseInt(tem2)));
                continue;
            }
        }

        return Integer.parseInt(st.pop());
    }


    //第二种解法
    public int calculate2(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0; //result: 当前的结果值; opr: 当前的被加/被减数
        Character op = null; //当前要执行的运算符
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    //遇到第一个运算符时，将result置为opr（即第一个运算符左边的数字）
                    result = opr;
                } else {
                    //result = result +/- opr;
                    result = cal(op, result, opr);
                }
                //根据栈顶元素决定是否反转运算符
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }
        if (op == null) {
            //算式中没有运算符时，opr就是最终结果
            return opr;
        } else {
            //否则将result与opr（即算式中最右边的数字）执行一次运算
            return cal(op, result, opr);
        }
    }

    char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(char op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }


    public static void main(String[] args) {
        _224_基本计算器 t = new _224_基本计算器();
        System.out.println(t.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
