package 数组和串;

import java.util.*;

public class _973_最接近原点的K个点 {

    /**
     * 变相的 topK 问题，求最小的K个数，用最大堆
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        Map<int[], Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point, point[0] * point[0] + point[1] * point[1]);
        }

        PriorityQueue<Map.Entry<int[], Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<int[], Integer>>() {
            @Override
            public int compare(Map.Entry<int[], Integer> o1, Map.Entry<int[], Integer> o2) {
                // 最大堆
                return o1.getValue() - o2.getValue();
            }
        });
        Set<Map.Entry<int[], Integer>> entries = map.entrySet();
        for (Map.Entry<int[], Integer> entry : entries) {
            if (heap.size() < K) {
                heap.add(entry);
                continue;
            }
            if (entry.getValue() < heap.peek().getValue()) {
                heap.remove();
                heap.add(entry);
            }
        }
        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = heap.remove().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        _973_最接近原点的K个点 obj = new _973_最接近原点的K个点();
        int[][] ints = obj.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0]);
            System.out.println(ints[i][1]);
            System.out.println("==========");
        }
    }
}
