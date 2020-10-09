package 剑指offer;


import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
public class _38_字符串的排列 {

    //用一个set进行去重是比较简单的方式
    Set<String> set = new HashSet<>();

    /**
     * 方法一:按照无重复元素的排列组合的模板进行dfs，只需要将结果去重即可
     * 用set方法去重是比较容易理解也容易写出的算法，但是时间复杂度过高
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        permutation(chars, 0);
        String[] strings = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            strings[i++] = s1;
        }
        return strings;
    }

    private void permutation(char[] chars, int index) {
        if (index == chars.length) {
            set.add(new String(chars));
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutation(chars, index + 1);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int index1, int index2) {
        char t = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = t;
    }
}
