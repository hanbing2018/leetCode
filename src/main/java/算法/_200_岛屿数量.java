package 算法;

/**
 * @author hanbing
 * @date 2020-10-05 20:53
 */

//https://leetcode-cn.com/problems/number-of-islands/
public class _200_岛屿数量 {

    /**
     * dfs解法。遍历每一个点，是0则跳过，是1则开始dfs，每遇到一个1则置为0，
     * 从1的上下左右四个方向进行dfs
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int res = 0;
        int cows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < cows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                if (grid[i][i1] == '0') continue;
                res++;
                dfs(grid, i, i1);
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int cowIdx, int colIdx) {
        int cows = grid.length;
        int cols = grid[0].length;

        if (cowIdx < 0 || cowIdx >= cows || colIdx < 0 || colIdx >= cols || grid[cowIdx][colIdx] == '0') return;

        grid[cowIdx][colIdx] = '0';

        dfs(grid, cowIdx - 1, colIdx);
        dfs(grid, cowIdx + 1, colIdx);
        dfs(grid, cowIdx, colIdx - 1);
        dfs(grid, cowIdx, colIdx + 1);
    }
}
