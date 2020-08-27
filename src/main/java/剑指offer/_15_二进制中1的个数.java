package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-04 12:12
 */

//https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
public class _15_二进制中1的个数 {

    /**
     * 考察位运算，n与1进行位运算，无符号右移一位
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            if ((n&1) == 1) count++;
            n = n>>>1;
        }
        return count;
    }
}
