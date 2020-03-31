package 剑指offer;

/**
 * @author hanbing
 * @create 2020-03-31 10:09
 */

//https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/submissions/
public class _05_替换空格 {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] charArray = new char[len*3];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' '){
                charArray[size++] = '%';
                charArray[size++] = '2';
                charArray[size++] = '0';
            }else {
                charArray[size++] = s.charAt(i);
            }
        }
        return new String(charArray, 0, size);
    }
}
