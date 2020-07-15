package 剑指offer;


//https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
public class _43_1到n整数中1出现的次数 {


    public int countDigitOne(int n) {
        int result = 0;
        int low = 0;
        int cur = n%10;
        int high = n/10;
        int digit = 1;
        while (high!=0 || cur!=0){
            if (cur==0){
                result += digit*high;
            }else if(cur==1){
                result += digit*high + low +1;
            }else {
                result += (high + 1)*digit;
            }

            low += cur*digit;
            cur = high%10;
            high = high/10;
            digit = digit*10;
        }

        return result;
    }
}
