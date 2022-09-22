package 数组和串;


//https://leetcode-cn.com/problems/rotate-array/
public class _189_旋转数组 {

    /**
     * 见官方题解
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) return;

        int count = nums.length;
        for (int i = 0; count > 0; i++) {
            //当前值
            int cur = nums[i];
            //当前值需要移动到的地址
            int toIdx = (i + k) % nums.length;
            do {
                int t = nums[toIdx];
                nums[toIdx] = cur;
                cur = t;
                toIdx = (toIdx + k) % nums.length;

                count--;
            } while ((i + k) % nums.length != toIdx);
        }
        return;
    }
}
