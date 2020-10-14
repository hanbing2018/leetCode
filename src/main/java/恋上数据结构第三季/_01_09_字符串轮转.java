package 恋上数据结构第三季;

/**
 * @author hanbing
 * @date 2020-10-14 21:08
 */

//https://leetcode-cn.com/problems/string-rotation-lcci/
public class _01_09_字符串轮转 {
    /**
     * 注意要判断长度两个串是否相等
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        s1 += s1;
        return s1.contains(s2);
    }
}
