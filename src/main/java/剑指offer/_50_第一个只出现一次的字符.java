package 剑指offer;


//https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
public class _50_第一个只出现一次的字符 {

    /**
     * 两次遍历即可
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return ' ';

        //新建一个26长的数组，用来统计每个字符出现的次数
        int[] counts = new int[26];
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }
        //第二次遍历还是遍历原数组，发现出现一次就返回
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) return chars[i];
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}


