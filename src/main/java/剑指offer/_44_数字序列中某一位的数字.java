package 剑指offer;


//https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
public class _44_数字序列中某一位的数字 {


    //参考题解
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;

        long count = start * digit * 9;

        while (n > count) {
            n -= count;
            start *= 10;
            digit++;
            count = start * digit * 9;
        }

        long num = start + (n - 1) / digit;
        String numStr = String.valueOf(num);
        return numStr.charAt((n - 1) % digit) - '0';
    }
}
