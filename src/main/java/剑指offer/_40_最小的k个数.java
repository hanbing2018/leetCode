package 剑指offer;


import java.util.Arrays;

//https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
public class _40_最小的k个数 {

    /**
     * 方法一：快速排序法的变形
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int leftIndex, int rigngIndex, int k) {
        int j = quickPai(arr, leftIndex, rigngIndex);
        if (j == k) return Arrays.copyOf(arr, k + 1);
        if (j > k) return quickSearch(arr, leftIndex, j - 1, k);
        if (j < k) return quickSearch(arr, j + 1, rigngIndex, k);
        return null;
    }

    private int quickPai(int[] arr, int leftIndex, int rigngIndex) {
        int i = leftIndex + 1;
        int j = rigngIndex;
        while (true) {

            while (i <= rigngIndex && arr[i] < arr[leftIndex]) i++;
            while (leftIndex + 1 <= j && arr[j] > arr[leftIndex]) j--;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            } else break;
        }
        int t = arr[j];
        arr[j] = arr[leftIndex];
        arr[leftIndex] = t;
        return j;
    }

    /**
     * 方法二：利用最大堆，PriorityQueue<Integer>
     */
}
