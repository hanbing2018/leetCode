package 数组和串;


//https://leetcode-cn.com/problems/rotate-array/
public class doing_189_旋转数组 {

    /**
     * 见官方题解
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int t = nums[0];
        int tem = 0;
        int index = k;
        int count = nums.length;
        while (count > 0) {
            index %= nums.length;
            tem = nums[index];
            nums[index] = t;
            t = tem;
            index += k;

            count--;
        }
        return;
    }
}
