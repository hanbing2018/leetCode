package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanbing
 * @create 2020-04-04 11:53
 */

//https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
public class _14_1_剪绳子 {

    /**
     * 方法一：动态规划，
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n==2) return 1; //绳子长为2，还要必须剪一刀，因此为1
        if (n==3) return 2;
        if (n==4) return 4;
        Map<Integer, Integer> map = new HashMap<>();
        //通过常识可以知道，当绳子长度>=4时，绳子片段不可能为1，否则不是最大值
        //以下map中三个值可以作为绳子片段的最小值，作为动态规划的初始值  f(n) = max(f(i)*f(n-i))  2<=i<=n/2,n>=5
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);

        for (int i = 5; i <= n; i++) {
            int max = 1;
            for (int j = 2; j <= i/2; j++){
                if (map.get(j)*map.get(i-j) > max){
                    max = map.get(j)*map.get(i-j);
                }
            }
            map.put(i, max);
        }
        return map.get(n);
    }

    /**
     * 方法二：贪婪算法。当绳子长>=5，尽可能剪最多的3，剩下4或者2。
     * 此方法的难点是首先要知道（或者会证明）对于绳长>=5，此方法是当前最优的
     */
}
