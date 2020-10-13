package 算法;

//https://leetcode-cn.com/problems/divide-two-integers/
public class _29_两数相除 {

    /**
     * 采用二分法的思想，dividend每次减去2^n个divisor（尽可能多），同时res每次加2^n
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long di = dividend;
        long de = divisor;
        int fu = 1;
        if (di < 0) {
            di = -di;
            fu *= -1;
        }
        if (de < 0) {
            de = -de;
            fu *= -1;
        }
        long res = 0;
        while (di >= de) {
            long t = de;
            long c = 1;
            while (di - t >= t) {
                t <<= 1;
                c <<= 1;
            }
            res += c;
            di -= t;

        }

        res *= fu;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        return (int) res;
    }

    /**
     * 方法二：循环相减。结果超时
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {
        long di = dividend;
        long de = divisor;
        int fu = 1;
        if (di < 0) {
            di = -di;
            fu *= -1;
        }
        if (de < 0) {
            de = -de;
            fu *= -1;
        }
        long res = 0;
        while (di >= de) {
            res++;
            di -= de;
        }

        res *= fu;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        return (int) res;
    }
}
