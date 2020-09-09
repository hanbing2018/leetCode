package 算法;


import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
public class _215_数组中的第K个最大元素 {


    /**
     * 方法一：利用最小堆。遍历数组加入堆中，最小堆中始终保持k个元素，如果新的数字大于堆顶则加入堆。最后返回堆顶。
     * 不使用内置堆难度mid。利用java中的内置堆结构，是一种偷懒的做法；在可以使用内置堆的情况下，本题easy
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size()<k){
                minHeap.offer(num);
                continue;
            }
            if (minHeap.peek() < num){
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }
}
