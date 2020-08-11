package 恋上数据结构第三季;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {

    /**
     * 用一个map存储key(数组元素的值)-val(该元素的位置)，依次遍历数组
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            Integer index = map.get(target- nums[i]);
            if (index!=null) return new int[]{index, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
