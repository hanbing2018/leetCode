package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/valid-anagram/
public class _242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s==null || t==null) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        if (schars.length != tchars.length) return false;

        int[] counts = new int[26];
        for (int i=0;i<schars.length;i++){
            counts[schars[i]-'a']++;
        }

        for (int i=0;i<schars.length;i++){
            if(--counts[tchars[i]-'a'] < 0) return false;
        }
        return true;
    }
}
