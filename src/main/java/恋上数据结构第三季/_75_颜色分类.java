package 恋上数据结构第三季;

/**
 * @author hanbing
 * @create 2020-04-27 9:20
 */

//https://leetcode-cn.com/problems/sort-colors/
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length -1;

        int t;
        while (j<=k){
            if (nums[j]==1){
                j++;
            }else if (nums[j]==0){
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                i++; j++;
            }else if (nums[j]==2){
                t = nums[j];
                nums[j] = nums[k];
                nums[k] = t;
                k--;
            }
        }
    }
}
