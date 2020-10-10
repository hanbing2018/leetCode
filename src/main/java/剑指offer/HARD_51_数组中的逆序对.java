package 剑指offer;


//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class HARD_51_数组中的逆序对 {

    public int reversePairs(int[] nums) {
        //使用归并排序计算逆序对是典型的解法，详细算法解释见LeetCode官方视频解

        if (nums.length <= 1) return 0;

        //复制原数组保证原数组不发生变化，若没有规定，则可以直接使用原数组进行操作
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[copy.length];  //用于归并排序的额外空间
        return reversePairs(copy, 0, copy.length - 1, temp);

    }

    public int reversePairs(int[] copy, int lIndex, int rIndex, int[] temp) {
        if (lIndex >= rIndex) return 0;

        int mid = lIndex + (rIndex - lIndex) / 2;
        int leftCount = reversePairs(copy, lIndex, mid, temp);
        int righrCount = reversePairs(copy, mid + 1, rIndex, temp);

        int midCount = mergeAndCount(copy, lIndex, mid, rIndex, temp);

        return leftCount + righrCount + midCount;
    }

    private int mergeAndCount(int[] copy, int lIndex, int mid, int rIndex, int[] temp) {
        for (int i = mid + 1; i <= rIndex; i++) {
            temp[i] = copy[i];
        }

        int count = 0;
        int k = rIndex;

        int l = mid;
        int r = rIndex;
        while (k >= lIndex) {

            if (r < (mid + 1)) {
                break;
            } else if (l < lIndex) {
                copy[k] = temp[r];
                k--;
                r--;
            } else if (copy[l] <= temp[r]) {
                copy[k] = temp[r];
                k--;
                r--;
            } else {
                copy[k] = copy[l];
                k--;
                l--;
                count += (r - mid);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HARD_51_数组中的逆序对 p = new HARD_51_数组中的逆序对();
        p.reversePairs(new int[]{7, 5, 6, 4});
    }
}
