package 恋上数据结构第三季;


import java.util.Deque;
import java.util.LinkedList;

//https://leetcode-cn.com/problems/sliding-window-maximum/
public class _239_滑动窗口最大值 {

    /**
     * 方法一：时间复杂度为O(n)
     * 此题为困难，要求时间复杂度为O(n)。用一个存储索引值的双端队列实现
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //特殊情况检查
        if (k==1) return nums;

        int[] res = new int[nums.length - k +1];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i< nums.length){
            //从尾部依次删除比nums[i]小的值，将nums[i]填入到队列中
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

            //队列中最大值索引已经超出当前窗口，则移除
            j = i - k + 1;
            if (j>=0 ){
                if (deque.peekFirst()<j) deque.pollFirst();
                res[j] = nums[deque.peekFirst()];
            }
            i++;
        }
        return res;

    }

    /**
     * 方法二：时间复杂度为O(k*n),实际速度可能比方法一更快
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];
        // 当前滑动窗口的最大值索引
        int maxIdx = 0;
        // 求出前k个元素的最大值索引
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        // li是滑动窗口的最左索引
        for (int li = 0; li < maxes.length; li++) {
            // ri是滑动窗口的最右索引
            int ri = li + k - 1;
            if (maxIdx < li) { // 最大值的索引不在滑动窗口的合理范围内
                // 求出[li, ri]范围内最大值的索引
                maxIdx = li;
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIdx]) maxIdx = i;
                }
            } else if (nums[ri] >= nums[maxIdx]) { // 最大值的索引在滑动窗口的合理范围内
                maxIdx = ri;
            }
            maxes[li] = nums[maxIdx];
        }

        return maxes;
    }
}
