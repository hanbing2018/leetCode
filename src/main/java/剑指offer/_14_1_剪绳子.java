package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanbing
 * @create 2020-04-04 11:53
 */

//https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
public class _14_1_剪绳子 {
    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;
        Map<Integer, Integer> map = new HashMap<>();
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
}
