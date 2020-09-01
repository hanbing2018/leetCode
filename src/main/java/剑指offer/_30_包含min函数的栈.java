package 剑指offer;

import java.util.Stack;

/**
 * @author hanbing
 * @create 2020-04-14 15:48
 */

//https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
public class _30_包含min函数的栈 {

    /**
     * 用两个栈实现，一个栈存数据，另一个存当前最小值
     */

    private Stack<Integer> stack;
    private Stack<Integer> stackMin;  //存储当前的最小值

    /** initialize your data structure here. */
    public _30_包含min函数的栈() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        if (stackMin.isEmpty() || stackMin.peek()>=x){
            stackMin.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int pop = stack.pop();
        if (pop==stackMin.peek()) stackMin.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
