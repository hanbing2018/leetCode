package 剑指offer;


import java.util.*;

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

    /**
     * 方法二：参考_47_全排列_II，利用dfs+剪枝的方法，避免set去重，减少时间复杂度
     * 实际测试通过，但是时间很慢，比方法一还要慢
     *
     * @param s
     * @return
     */
    public String[] permutation2(String s) {
        char[] charS = s.toCharArray();
        //存储最终结果
        List<String> res = new LinkedList<>();
        //存储每一次遍历到底的结果
        char[] charRes = new char[charS.length];
        //记录是否被访问过
        boolean[] used = new boolean[charS.length];

        //先将charS排序，必须进行这一步
        Arrays.sort(charS);
        dfs(charS, used, 0, res, charRes);

        //处理结果即可
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void dfs(char[] charS, boolean[] used, int index, List<String> res, char[] charRes) {
        if (index == charS.length) {
            res.add(new String(charRes));
            return;
        }

        for (int i = 0; i < charS.length; i++) {
            if (used[i] || i > 0 && charS[i] == charS[i - 1] && !used[i - 1]) continue;
            charRes[index] = charS[i];
            used[i] = true;
            dfs(charS, used, index + 1, res, charRes);
            used[i] = false;
        }
    }
}
