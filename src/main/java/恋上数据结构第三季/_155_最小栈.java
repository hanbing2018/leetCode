package 恋上数据结构第三季;


import java.util.Stack;

//https://leetcode-cn.com/problems/min-stack/
public class _155_最小栈 {


    /**
     * 方法一：用两个栈，分别存储元素和元素的最小值
     */
    /* 用来存放正常数据 */
	private Stack<Integer> stack;
	/* 用来存放最小数据 */
	private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _155_最小栈() {
    	stack = new Stack<>();
    	minStack = new Stack<>();
    }

    public void push(int x) {
    	stack.push(x);
    	if (minStack.isEmpty()) {
    		minStack.push(x);
    	} else {
    		minStack.push(Math.min(x, minStack.peek()));
    	}
    }

    public void pop() {
    	stack.pop();
    	minStack.pop();
    }

    public int top() {
    	return stack.peek();
    }

    public int getMin() {
    	return minStack.peek();
    }

    /**
     * 方法二：用链表实现，新建一个包含目前最小值的节点类
     */
/*
	private Node head;
	public MinStack() {
		head = new Node(0, Integer.MAX_VALUE, null);
	}
	public void push(int x) {
		head = new Node(x, Math.min(x, head.min), head);
	}
	public void pop() {
		head = head.next;
	}
	public int top() {
		return head.val;
	}
	public int getMin() {
		return head.min;
	}
	private static class Node {
		public int val;
		public int min;
		public Node next;
		public Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
*/




}
