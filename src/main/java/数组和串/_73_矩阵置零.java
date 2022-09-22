package 数组和串;

//https://leetcode-cn.com/problems/set-matrix-zeroes/
public class _73_矩阵置零 {
    /**
     * 从下标1开始遍历，如果是0则将第一行第一列对应位置置零；
     * 遍历第一行和第一列，是0则将改行或该列都置零
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        //记录第1行和第1列中是否有0
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = matrix[i][j] == 0 ? 0 : matrix[0][j];
                matrix[i][0] = matrix[i][j] == 0 ? 0 : matrix[i][0];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[0][j] == 0 || matrix[i][0] == 0) ? 0 : matrix[i][j];
            }
        }
        //第一行或第一列找那个存在0则将第一行或第一列都置零
        if (rowFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        _73_矩阵置零 obj = new _73_矩阵置零();
        obj.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println("=============");
        }
    }
}
