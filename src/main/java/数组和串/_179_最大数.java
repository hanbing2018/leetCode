package 数组和串;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode-cn.com/problems/largest-number/
public class _179_最大数 {

    /**
     * 本题可以简单理解为一个排序问题
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        String[] sts = new String[nums.length];
        for (int i = 0; i < sts.length; i++) {
            sts[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(sts, new Comparator<String>() {
            //从大到小排序
            @Override
            public int compare(String o1, String o2) {
                char[] chs1 = o1.toCharArray();
                char[] chs2 = o2.toCharArray();
                int l = 0;
                while (l < chs1.length && l < chs2.length) {
                    if (chs1[l] > chs2[l]) return 1;
                    if (chs1[l] < chs2[l]) return -1;
                    l++;
                }
                if (chs1.length == chs2.length) return 0;
                if (chs1.length > chs2.length) {
                    return -compare(o1.substring(0, l), o1.substring(l, o1.length()));
                }
                if (chs1.length < chs2.length) {
                    return compare(o2.substring(0, l), o2.substring(l, o2.length()));
                }
                return 0;
            }
        });

        //考虑都是0的情况
        if (sts[sts.length - 1].equals("0")) return "0";
        //此时字符创数组是按照从小到大的顺序排列的
        StringBuilder sb = new StringBuilder();
        for (int i = sts.length - 1; i >= 0; i--) {
            sb.append(sts[i]);
        }
        return sb.toString();
    }
}
