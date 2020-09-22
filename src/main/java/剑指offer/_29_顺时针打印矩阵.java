package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-14 14:39
 */

//https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
public class _29_顺时针打印矩阵 {

    /**
     * 本题思路很容易想到，难点在于边界条件的判断。面试高频，重点关注此题！
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int cows = matrix.length;
        if (cows == 0) return new int[0];
        int cols = matrix[0].length;
        int[] array = new int[cows * cols];
        int start = 0;
        int k = 0;
        while (start * 2 < cows && start * 2 < cols) {
            //从左到右
            for (int i = start; i <= cols - 1 - start; i++) {
                array[k++] = matrix[start][i];
            }
            //从上到下
            if (cows - 1 - start > start) {
                for (int i = start + 1; i <= cows - 1 - start; i++) {
                    array[k++] = matrix[i][cols - 1 - start];
                }
            }
            //从右到左
            if (cols - 1 - start > start && cows - 1 - start > start) {
                for (int i = cols - 2 - start; i >= start; i--) {
                    array[k++] = matrix[cows - 1 - start][i];
                }
            }
            //从下到上
            if (cols - 1 - start > start && cows - 2 - start > start) {
                for (int i = cows - 2 - start; i >= start + 1; i--) {
                    array[k++] = matrix[i][start];
                }
            }


            start++;
        }
        return array;
    }
}
