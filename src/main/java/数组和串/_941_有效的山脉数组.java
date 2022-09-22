package 数组和串;


//https://leetcode-cn.com/problems/valid-mountain-array/
public class _941_有效的山脉数组 {

    /**
     * 双指针解法。从左右指向最大的数，如果相等则为山脉数组
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;

        //l指向左数最大的数
        int l = 0;
        while (l < arr.length - 1) {
            if (arr[l] == arr[l + 1]) {
                return false;
            } else if (arr[l] > arr[l + 1]) {
                break;
            } else {
                l++;
            }
        }
        int r = arr.length - 1;
        while (r > 0) {
            if (arr[r] == arr[r - 1]) {
                return false;
            } else if (arr[r] > arr[r - 1]) {
                break;
            } else {
                r--;
            }
        }

        if (l == arr.length - 1 || r == 0 || l != r) return false;

        return true;
    }
}
