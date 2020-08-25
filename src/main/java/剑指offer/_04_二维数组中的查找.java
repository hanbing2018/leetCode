package 剑指offer;

/**
 * @author hanbing
 * @create 2020-03-31 9:42
 */

//https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
public class _04_二维数组中的查找 {

    /**
     * 从右上角开始比较，向下向左移动后比较
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) return false;
        int m = 0;
        int n = matrix[0].length - 1;

        while (m<=matrix.length-1 && n>=0){
            if (matrix[m][n] > target){
                n--;
                continue;
            }else if (matrix[m][n] < target){
                m++;
                continue;
            }else {
                return true;
            }
        }
        return false;
    }
}
