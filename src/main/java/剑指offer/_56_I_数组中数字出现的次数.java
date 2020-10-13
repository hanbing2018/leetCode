package 剑指offer;


//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
public class _56_I_数组中数字出现的次数 {

    /**
     * 考察位运算。任何数与0做抑或运算是它本身，一个数与自身做抑或为0。
     * 因此只需要将所有数进行位运算，最终结果就是只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int mark = 1;
        while ((res & mark) == 0) {
            mark <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mark) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
