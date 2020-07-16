package 剑指offer;


//https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
public class _46_把数字翻译成字符串 {

    public int translateNum(int num) {

        //动态规划
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length==1) return 1;
        int[] res = new int[chars.length];

        res[0]  = 1;
        if (chars[0]=='1' || (chars[0]=='2' && chars[1]>= '0' && chars[1]<= '5')){
            res[1] = 2;
        }else {
            res[1] = 1;
        }
        for (int i = 2; i < chars.length; i++) {
            res[i] += res[i-1];
            if (chars[i-1]=='1' || (chars[i-1]=='2' && chars[i]>= '0' && chars[i]<= '5')){
                res[i]+= res[i-2];
            }
        }
        return res[res.length-1];
    }
}
