package 数组和串;

//https://leetcode-cn.com/problems/long-pressed-name/
public class _925_长按键入 {
    /**
     * 遍历两个字符串，依次比较
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        char[] nameChs = name.toCharArray();
        char[] typedChs = typed.toCharArray();

        int i = 0;
        int j = 0;
        while (i < nameChs.length && j < typedChs.length) {
            if (nameChs[i] == typedChs[j]) {
                i++;
                j++;
            } else if (j == 0 || typedChs[j] != typedChs[j - 1]) {  //如果第一个字符不一样，或者typed出现非重复的字符
                return false;
            } else {
                j++;
            }
        }
        //如果type结尾出现非重复的字符
        while (j < typedChs.length) {
            if (typedChs[j] != typedChs[j - 1]) {
                return false;
            } else {
                j++;
            }
        }

        return i == nameChs.length;
    }
}
