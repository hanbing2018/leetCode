package 集合;

import java.util.*;

/**
 * @author hanbing
 * @create 2020-01-06 19:03
 */

//https://leetcode-cn.com/problems/intersection-of-two-arrays/
public class _349_两个数组的交集 {

    /**
     * 用两个Set去重后，遍历一个Set，判断是否被第二个Set包含，是则属于交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {  //去重
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        List<Integer> list = new LinkedList<>();
        for (Integer i : set2) {
            if (set1.contains(i)) list.add(i);
        }
        int[] nums3 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums3[i] = list.get(i);
        }

        return nums3;
    }
}
