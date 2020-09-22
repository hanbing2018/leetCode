package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-03 18:44
 */

//https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class _13_机器人的运动范围 {

    /**
     * 回溯算法，从开始位置开始回溯判断，将可以移动过去的位置设置为ture，最后返回为true的数量
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        moving(0, 0, m, n, k, visited);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void moving(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m) return;
        if (j < 0 || j >= n) return;
        if (gsum(i, j) > k) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        moving(i + 1, j, m, n, k, visited);
        moving(i - 1, j, m, n, k, visited);
        moving(i, j + 1, m, n, k, visited);
        moving(i, j - 1, m, n, k, visited);
    }

    private int gsum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += (i % 10);
            i /= 10;
        }
        while (j > 0) {
            sum += (j % 10);
            j /= 10;
        }
        return sum;
    }
}
