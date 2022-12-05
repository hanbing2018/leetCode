package 数组和串;

/**
 * @author hanbing
 * @date 2022-12-06 1:47
 */

// https://leetcode.cn/problems/string-to-integer-atoi/?favorite=2ckc81c
public class _8_字符串转换整数_atoi {

    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        int res = 0;
        int flag = 1;
        int i = 0;
        while(i < chars.length) {
            if(chars[i] == ' ') {
                i++;
            } else break;
        }

        if (i == chars.length) return 0;

        if (chars[i] == '+') {
            i++;
        }else if (chars[i] == '-') {
            flag = -1;
            i++;
        }

        while(i < chars.length) {
            if (chars[i] < '0' || chars[i] > '9') break;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && chars[i] - '0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && chars[i] - '0' > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + flag * (chars[i] - '0');
            i++;
        }

        return res;
    }
}
