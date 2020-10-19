package 数组和串;

//https://leetcode-cn.com/problems/backspace-string-compare/
public class _844_比较含退格的字符串 {
    /**
     * 双指针解法，分别从右到左遍历两个字符串的每一个字符进行比较
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
            } else if (i >= 0 || j >= 0) {  //如果一个字符串遍历完了，另一个还没有遍历完
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
