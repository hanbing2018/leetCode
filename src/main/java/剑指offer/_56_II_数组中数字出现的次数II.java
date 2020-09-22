package 剑指offer;


//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
public class _56_II_数组中数字出现的次数II {

    public int singleNumber(int[] nums) {
        int[] bitCounts = new int[32];
        int mark;

        for (int i = 0; i < 32; i++) {
            mark = 1 << (31 - i);
            for (int num : nums) {
                if ((num & mark) != 0) bitCounts[i]++;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bitCounts[i] % 3;
        }
        return res;
    }
}
