package 恋上数据结构第三季;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class _3_无重复字符的最长子串 {

    /**
     * 类似动态规划的方法，依次求出以当前字母为结尾的最长不重复子串的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        //存放当前字符的上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();

        //index=0的字符特殊处理
        //先把首字符加入到map中
        map.put(chars[0], 0);
        //以前一个字符为结尾的最长不重复的子串首字母索引，从index=1开始遍历所以li初始值为0
        int li = 0;
        int max = 1;  //最长不重复子串的长度，从index=1开始遍历所以max初始值为1

        //从index=1开始遍历
        for (int i = 1; i < chars.length; i++) {
            Integer preIndex = map.get(chars[i]);
            //判断li的值是否需要改变
            if (preIndex != null && preIndex >= li) {
                li = preIndex + 1;
            }
            map.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }

        return max;
    }
}
