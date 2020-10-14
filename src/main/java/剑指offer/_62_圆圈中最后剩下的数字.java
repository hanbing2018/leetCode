package 剑指offer;

/**
 * @author hanbing
 * @date 2020-10-14 21:52
 */

//https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
public class _62_圆圈中最后剩下的数字 {

    /**
     * 公式  f(n,m) = (f(n-1,m)+m)%n
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
