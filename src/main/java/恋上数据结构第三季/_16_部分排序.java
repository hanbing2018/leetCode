package 恋上数据结构第三季;

/**
 * @author hanbing
 * @create 2020-04-27 16:11
 */

//https://leetcode-cn.com/problems/sub-sort-lcci/
public class _16_部分排序 {

    /**
     * 最左边的逆序对的左边的数的位置就是左边界
     * 最右边的逆序对的右边的数的位置就是右边界
     *
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};

        int l = -1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            if (v >= max) {
                max = v;
            } else {
                l = i;
            }
        }

        int r = -1;
        int min = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            int v = array[i];
            if (v <= min) {
                min = v;
            } else {
                r = i;
            }
        }

        return new int[]{r, l};
    }
}
