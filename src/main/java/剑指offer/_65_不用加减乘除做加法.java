package 剑指offer;


//https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
public class _65_不用加减乘除做加法 {

    /**
     * 是属于运用位运算的技巧型题目。没什么意思，面试基本不会遇到
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {

        int c;
        int r;
        c = a ^ b;
        r = (a & b) << 1;
        a = c;
        b = r;
        while (r != 0) {
            c = a ^ b;
            r = (a & b) << 1;

            a = c;
            b = r;
        }

        return c;
    }
}
