package 剑指offer;

import sun.util.resources.cldr.my.CurrencyNames_my;

/**
 * @author hanbing
 * @create 2020-04-07 9:45
 */

//https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
public class _16_数值的整数次方 {
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
