package 栈;

import sun.security.util.Length;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2019-12-27 11:30
 */

//https://leetcode-cn.com/problems/basic-calculator/
public class _224_基本计算器 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        Stack<String> stackSimp = new Stack<String>();
        String tems;

        int len = s.length();
        for (int i=0;i<len;i++){  //循环遍历字符串的每一个字符
            tems = s.substring(i,i+1);
            if (tems.equals(" ")){  //如果是空格
                continue;
            }
            if (tems.equals("(")){ //如果是左括号，加入到栈中
                stack.push(tems);
                continue;
            }
            if (tems.equals(")")){  //如果是右括号，则计算此右括号到左括号的表达式的值
                String temm;
                while (!(temm=stack.pop()).equals("(")){
                    stackSimp.push(temm);
                }
                stack.push(String.valueOf(calculateSimple(stackSimp)));
                continue;
            }
            if (tems.equals("+") || tems.equals("-")){  //如果是运算符，加入栈中
                stack.push(tems);
                continue;
            }

            //如果是数值，则加入到栈中
            int sum = Integer.parseInt(tems);
            while((i+1)< len && Character.isDigit(s.charAt(i+1))){
                i++;
                sum = sum*10 + Integer.parseInt(s.substring(i,i+1));
            }
            stack.push(String.valueOf(sum));
        }

        while (!stack.isEmpty()){
            stackSimp.push(stack.pop());
        }

        return calculateSimple(stackSimp);
    }

    public int calculateSimple(Stack<String> st){
        String tem1;
        String temf;
        String tem2;
        while (true){
            if (st.size() == 1) break;

            tem1 = st.pop();
            temf = st.pop();
            tem2 = st.pop();
            if (temf.equals("+")){
                st.push(String.valueOf(Integer.parseInt(tem1)+ Integer.parseInt(tem2)));
                continue;
            }
            if (temf.equals("-")){
                st.push(String.valueOf(Integer.parseInt(tem1)-Integer.parseInt(tem2)));
                continue;
            }
        }

        return Integer.parseInt(st.pop());
    }


    public static void main(String[] args) {
        _224_基本计算器 t = new _224_基本计算器();
        System.out.println(t.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
