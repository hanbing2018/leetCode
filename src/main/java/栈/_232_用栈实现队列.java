package 栈;

import java.util.Stack;

/**
 * @author hanbing
 * @date 2019-12-27 17:57
 */
public class _232_用栈实现队列 {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    /** Initialize your data structure here. */
    public _232_用栈实现队列() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        _232_用栈实现队列 s = new _232_用栈实现队列();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
    }
}
