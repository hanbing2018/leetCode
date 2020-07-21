package 剑指offer;


import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
public class _61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            if(set.contains(num)) return false;
            else set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min < 5;
    }
}


