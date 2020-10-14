package 数组和串;

import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/find-common-characters/
public class _1002_查找常用字符 {

    /**
     * 思路与算法
     * <p>
     * 如果字符c在所有字符串中均出现了k次及以上，那么最终答案中需要包含k个c。
     * 可以使用 mcnfreq[c]存储字符c在所有字符串中出现次数的最小值。
     * 遍历每一个字符串。当遍历到字符串s时，我们使用freq[c]统计s中每一个字符c出现的次数。
     * 在统计完成之后，我们再将每一个 mcnfreq[c]更新为其本身与 freq[c]的较小值。
     * 遍历完所有字符串后，mcnfreq[c]就存储了字符c在所有字符串中出现次数的最小值。
     * 由于题目保证了所有的字符均为小写字母，因此我们可以用长度为26的数组分别表示 mcnfreq以及freq。
     *
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        for (int i = 0; i < 26; i++) {
            minfreq[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            int[] freq = new int[26];
            for (int j = 0; j < chars.length; j++) {
                freq[chars[j] - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                minfreq[k] = Math.min(minfreq[k], freq[k]);
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < minfreq.length; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
