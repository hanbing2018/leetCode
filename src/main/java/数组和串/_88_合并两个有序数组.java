package 数组和串;

/**
 * @author hanbing
 * @create 2020-02-15 21:27
 */

/*https://leetcode-cn.com/problems/merge-sorted-array/
    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

            说明:

            初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
            你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素*/
public class _88_合并两个有序数组 {


    /**
     * 从后往前进行排序是最佳思路
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }

        int[] tem = new int[m];
        for (int i=0; i<m; i++){
            tem[i] = nums1[i];
        }
        int i = 0, j = m, k = 0;
        while (i<m){
            if (j<m+n && tem[i] > nums1[j]){
                nums1[k++] = nums1[j++];
            }else {
                nums1[k++] = tem[i++];
            }
        }
    }*/
}
