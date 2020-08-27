package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-07 9:45
 */

//https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
public class _16_数值的整数次方 {

    /**
     * 通过测试得知，原题中并没有考虑x为0的情况，所以下面的解法也通过了
     * 需要注意的是考虑n小于0的情况
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n >= 0){
            return myPowUnsigned(x, n);
        }else {
            return myPowUnsigned(1/x, -n);
        }
    }

    private double myPowUnsigned(double x, int n){
        if (n == 0) return 1;
        if (n == 1) return x;

        double result = myPowUnsigned(x, n>>>1);
        result*= result;
        if ((n&1) == 1){
            result*= x;
        }

        return result;
    }
}
