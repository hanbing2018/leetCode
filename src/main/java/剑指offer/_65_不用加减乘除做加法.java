package 剑指offer;


//https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
public class _65_不用加减乘除做加法 {

    public int add(int a, int b) {

        int c;
        int r;
        c = a^b;
        r = (a&b)<<1;
        a = c;
        b = r;
        while (r!=0){
            c = a^b;
            r = (a&b)<<1;

            a = c;
            b = r;
        }

        return c;
    }
}
