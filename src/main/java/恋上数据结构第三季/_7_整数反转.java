package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/reverse-integer/
public class _7_整数反转 {

    /**
     * 方法一：通过逆预算判断是否超出范围
     * 从个位开始依次进行反转，每次处理一位数字要判断数字是否可逆，若不可逆则表示超出整数范围，直接返回0
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pre = res;
            res = pre * 10 + x % 10;
            if (pre != (res - x % 10) / 10) return 0;
            x /= 10;
        }
        return res;
    }

    /**
     * 方法二：通过long类型存储值，判断是否超过int的范围
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) res;
    }
}
