package 算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//https://leetcode-cn.com/problems/insert-delete-getrandom-o1/submissions/
public class _380_常数时间插入删除和获取随机元素 {
    /**
     * 用一个int存储值val，用一个map存储val和val在数组中的索引。
     */
    int[] a;
    int size;
    Map<Integer, Integer> map;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public _380_常数时间插入删除和获取随机元素() {
        size = 0;
        a = new int[10000];
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        a[size] = val;
        map.put(val, size);
        size++;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        size--;
        a[index] = a[size];
        map.put(a[index], index);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return a[rand.nextInt(size)];  // nextInt(n)将返回一个大于等于0小于n的随机数，即：0 <= nextInt(n) < n
    }
}
