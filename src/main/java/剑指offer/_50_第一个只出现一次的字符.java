package 剑指offer;


//https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
public class _50_第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return ' ';

        int[] counts = new int[26];
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) return chars[i];
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}


