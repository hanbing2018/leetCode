package 算法;

//https://leetcode-cn.com/problems/word-search/
public class _79_单词搜索 {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (board[i][j] != chars[0]) continue;
                if (existCore(board, chars, 0, visited, i, j)) return true;
            }
        }

        return false;
    }

    private boolean existCore(char[][] board, char[] chars, int index, boolean[][] visited, int rowIdx, int colIdx) {
        if (index == chars.length) return true;
        if (rowIdx < 0 || rowIdx >= board.length) return false;
        if (colIdx < 0 || colIdx >= board[0].length) return false;
        if (visited[rowIdx][colIdx]) return false;
        if (board[rowIdx][colIdx] != chars[index]) return false;

        visited[rowIdx][colIdx] = true;
        if (existCore(board, chars, index + 1, visited, rowIdx + 1, colIdx)
                || existCore(board, chars, index + 1, visited, rowIdx - 1, colIdx)
                || existCore(board, chars, index + 1, visited, rowIdx, colIdx + 1)
                || existCore(board, chars, index + 1, visited, rowIdx, colIdx - 1)
        ) {
            return true;
        } else {
            visited[rowIdx][colIdx] = false;
            return false;
        }

    }
}
