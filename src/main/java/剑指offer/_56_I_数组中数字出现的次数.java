package 剑指offer;



//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
public class _56_I_数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int mark = 1;
        while ((res & mark) == 0){
            mark <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mark)==0){
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
