package 恋上数据结构第三季;

/**
 * @author hanbing
 * @create 2020-04-27 9:20
 */

//https://leetcode-cn.com/problems/sort-colors/
public class _75_颜色分类 {

    /**
     * 三指针，i从左到右指向第一个不是0的数，k从右到左指向第一个不是2的数。
     * j从0到length-1扫描
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        int t;
        while (j <= k) {       //注意结束条件，j和k相等时还要执行一次判断
            if (nums[j] == 1) {   //如果是1，继续扫描
                j++;
            } else if (nums[j] == 0) {  //如果是0，和nums[i]交换，i++，j++
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                i++;
                j++;
            } else if (nums[j] == 2) {  //如果是2，和nums[k]交换，k--
                t = nums[j];
                nums[j] = nums[k];
                nums[k] = t;
                k--;
            }
        }
    }
}
