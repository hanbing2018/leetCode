package 剑指offer;


import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
public class _61_扑克牌中的顺子 {

    /**
     * 属于抽象建模方面的题，没啥意思
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            //如果有重复的数字，则返回false
            if (set.contains(num)) return false;
            else set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        //set中有4或5个数字，只要最大小值相差小于5即可
        return max - min < 5;
    }
}


