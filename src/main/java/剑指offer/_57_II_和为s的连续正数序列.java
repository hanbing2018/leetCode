package 剑指offer;


import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
public class _57_II_和为s的连续正数序列 {

    /**
     * 利用滑动窗口。窗口初始值为[1,2],计算窗口的和根据情况滑动
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();

        //初始窗口为[1,2]
        int i = 1;
        int j = 2;
        int sum;

        //知道窗口只有一个值则退出
        while (i < j) {
            sum = (i + j) * (j - i + 1) / 2;
            //窗口和等于目标值
            if (sum == target) {
                int[] t = new int[j - i + 1];
                for (int k = 0; k <= j - i; k++) {
                    t[k] = k + i;
                }
                list.add(t);
                i++;
                continue;
            }
            //窗口和小于目标值窗口右边则向右扩展窗口
            if (sum < target) {
                j++;
                continue;
            }
            //窗口和大于目标值则窗口左边向右缩小窗口
            if (sum > target) {
                i++;
                continue;
            }

        }

        int[][] res = new int[list.size()][];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }

        return res;
    }
}
