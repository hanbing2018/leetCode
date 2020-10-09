package 算法;

/**
 * @author hanbing
 * @date 2020-10-01 21:33
 */

//https://leetcode-cn.com/problems/valid-sudoku/
public class _36_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                if (rows[i][num - '1']) return false;
                if (cols[j][num - '1']) return false;
                int local = (i / 3) * 3 + j / 3;
                if (boxes[local][num - '1']) return false;

                rows[i][num - '1'] = true;
                cols[j][num - '1'] = true;
                boxes[local][num - '1'] = true;
            }
        }
        return true;
    }
}
