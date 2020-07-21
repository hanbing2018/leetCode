package 剑指offer;


//https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
public class _67_把字符串转换成整数 {

    public int strToInt(String str) {
        if (str == null || str.length()==0) return 0;
        char[] chars = str.toCharArray();
        StringBuilder sb =new StringBuilder();
        int sign = 1;
        boolean flag = false;  //记录是否已经出现了正负号
        for (char aChar : chars) {
            if (sb.length()==0){
                if (aChar == ' ' && !flag) continue;
                if (aChar == '-' && !flag) {
                    sign = -1;
                    flag = true;
                    continue;
                }
                if (aChar == '+' && !flag) {
                    flag = true;
                    continue;
                }
                if (aChar>='0' && aChar<='9'){
                    sb.append(aChar);
                    continue;
                }
                return 0;
            }else if (aChar>='0' && aChar<='9'){
                sb.append(aChar);
            }else break;
        }

        char[] numChars = sb.toString().toCharArray();
        long l = 0;
        for (int i = 0; i < numChars.length; i++) {
           l =  l*10 + numChars[i]-'0';
           if (sign==1 && l>Integer.MAX_VALUE) return Integer.MAX_VALUE;
           if (sign==-1 && -l<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return sign*(int)l;
    }
}
