package 剑指offer;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
public class _41_数据流中的中位数 {

    //最小堆
    private Queue<Integer> minDui = new PriorityQueue();
    //最大堆
    private Queue<Integer> maxDui = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void addNum(int num) {
        if (maxDui.isEmpty()) {
            maxDui.offer(num);
            return;
        }
        if (minDui.isEmpty()) {
            if (num < maxDui.peek()) {
                minDui.offer(maxDui.poll());
                maxDui.offer(num);
                return;
            } else {
                minDui.offer(num);
                return;
            }
        }

        //最小堆和最大堆都不为空，始终保持maxDui.size()-minDui.size() 等于1或0
        if (maxDui.size() == minDui.size()) {
            if (num <= minDui.peek()) {
                maxDui.offer(num);
            } else {
                maxDui.offer(minDui.poll());
                minDui.offer(num);
            }
        } else {
            if (num >= maxDui.peek()) {
                minDui.offer(num);
            } else {
                minDui.offer(maxDui.poll());
                maxDui.offer(num);
            }
        }
    }

    public double findMedian() {
        if (maxDui.size() > minDui.size()) {
            return maxDui.peek();
        } else {
            return (0.0 + maxDui.peek() + minDui.peek()) / 2;
        }
    }
}
