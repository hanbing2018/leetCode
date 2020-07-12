package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/reverse-words-in-a-string/
public class _151_翻转字符串里的单词 {

    public String reverseWords(String s) {
        if (s==null) return null;
        char[] chars = s.toCharArray();
        if (chars.length==0) return "";

        //替换收尾空格，将内部连续的空格变为一个空格
        //当前的位置
        int cur = 0;
        boolean pre = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=' '){
                chars[cur++] = chars[i];
                pre = false;
            }else if (!pre){
                chars[cur++] = chars[i];
                pre = true;
            }
        }

        //新字符串的长度
        int len = chars[chars.length-1]==' '? (cur-1):cur;
        //如果原字符串都是空格
        if (len<=0) return "";

        //先翻转字符串
        reverseString(chars, 0, len-1);
        //再翻转每个单词
        int preIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i]==' '){
                reverseString(chars, preIndex+1,i-1);
                preIndex = i;
            }
        }
        reverseString(chars, preIndex+1, len-1);

        return new String(chars, 0, len);
    }

    public void reverseString(char[] chars, int leftIndex, int rightIndex){
        char t;
        while (leftIndex<rightIndex){
            t = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = t;
            leftIndex++;
            rightIndex--;
        }
    }
}
