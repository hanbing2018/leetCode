package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-31 1:08
 */

//https://leetcode-cn.com/problems/implement-stack-using-queues/
public class _225_用队列实现栈 {

    /**
     * 用两个队列A B，始终保持其中一个队列为空。
     * 添加：将元素添加到空队列A中，然后将另一个队列B元素依次添加到A中
     * 取出：哪个队列不为空就从中poll一个
     */

    Queue<Integer> queueIn = new LinkedList<>();
    Queue<Integer> queueOut = new LinkedList<>();


    /**
     * Initialize your data structure here.
     */
    public _225_用队列实现栈() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queueIn.isEmpty()) {
            queueIn.offer(x);
            while (!queueOut.isEmpty()) {
                queueIn.offer(queueOut.poll());
            }
        } else {
            queueOut.offer(x);
            while (!queueIn.isEmpty()) {
                queueOut.offer(queueIn.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queueIn.isEmpty()) {
            return queueIn.poll();
        } else {
            return queueOut.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!queueIn.isEmpty()) {
            return queueIn.peek();
        } else {
            return queueOut.peek();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueOut.isEmpty() && queueIn.isEmpty();
    }
}
