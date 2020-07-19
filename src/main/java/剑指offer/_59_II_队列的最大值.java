package 剑指offer;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
public class _59_II_队列的最大值 {
    Queue<Integer> ben = new LinkedList<>();
    Deque<Integer> max = new LinkedList<>();

    public int max_value() {
        if (ben.isEmpty()) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        ben.offer(value);
        while (max.size()!=0 && max.peekLast()<value){
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if (ben.isEmpty()) return -1;

        int p = ben.poll();
        if (p == max.peekFirst()){
            max.pollFirst();
        }
        return p;
    }
}
