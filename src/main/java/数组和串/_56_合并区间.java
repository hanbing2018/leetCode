package 数组和串;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/merge-intervals/
public class _56_合并区间 {

    /**
     * 按区间左端将区间排序，遍历各个区间加入list：
     * 如果当前区间和list尾部区间不重复，加入当前区间到list中，
     * 如果有重复，更新list尾部区间的右端
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0 || res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                int[] tail = res.get(res.size() - 1);
                tail[1] = Math.max(tail[1], intervals[i][1]);
            }
        }

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
