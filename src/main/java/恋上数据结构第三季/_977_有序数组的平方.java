package 恋上数据结构第三季;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2020-08-13 21:28
 */

//https://leetcode-cn.com/problems/squares-of-a-sorted-array/
public class _977_有序数组的平方 {

    /**
     * 方法一：平方后加入到最小堆，依次取出最小堆的数值即为结果
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return new int[0];

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 < o1) return 1;
                else return -1;
            }
        });

        for (int i : A) {
            queue.add(i * i);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.remove();
        }

        return res;
    }

    //方法二：双指针指向两端，向中间靠拢。比较两个指针指向的数绝对值大小，大数计算平方。
}
