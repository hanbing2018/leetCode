package 数组和串;

/**
 * @author hanbing
 * @date 2020-10-17 20:58
 */

//https://leetcode-cn.com/problems/rotate-image/
public class _48_旋转图像 {
    /**
     * 先左上右下调换，再每一行左右调换
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;
        int t;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix.length - 1;
            while (l < r) {
                t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;
                l++;
                r--;
            }
        }
    }
}
