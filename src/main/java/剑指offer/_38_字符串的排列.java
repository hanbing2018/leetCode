package 剑指offer;


import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
public class _38_字符串的排列 {

    Set<String> set = new HashSet<>();
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

    public void permutation(char[] chars, int index){
        if (index==chars.length){
            set.add(new String(chars));
        }

        for (int i=index; i<chars.length;i++){
            swap(chars, index, i);
            permutation(chars, index+1);
            swap(chars, index, i);
        }
    }

    public void swap(char[] chars, int index1, int index2){
        char t = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = t;
    }

    public static void main(String[] args) {
        _38_字符串的排列 p = new _38_字符串的排列();
        p.permutation("abc");
    }
}
