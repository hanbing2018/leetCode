package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-03 18:04
 */

//https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
public class _12_矩阵中的路径 {

    /**
     * 回溯算法，遍历二维数组的每个位置作为起点，existCore函数通过回溯来确定是否有路径
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols]; //存储是否访问过
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existCore(i, j, board, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existCore(int i, int j, char[][] board, String word, boolean[][] visited, int indexOfWord) {
        if (indexOfWord == word.length()) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (visited[i][j] == true) return false;
        if (board[i][j] != word.charAt(indexOfWord)) return false;
        visited[i][j] = true;
        if (existCore(i + 1, j, board, word, visited, indexOfWord + 1)
                || existCore(i - 1, j, board, word, visited, indexOfWord + 1)
                || existCore(i, j + 1, board, word, visited, indexOfWord + 1)
                || existCore(i, j - 1, board, word, visited, indexOfWord + 1)) {
            return true;
        } else {
            visited[i][j] = false;
            return false;
        }
    }
}
