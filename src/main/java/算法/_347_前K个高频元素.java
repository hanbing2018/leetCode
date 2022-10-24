package 算法;


import java.util.*;

//https://leetcode-cn.com/problems/top-k-frequent-elements/
public class _347_前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else {
                if (entry.getValue() > heap.peek().getValue()) {
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
