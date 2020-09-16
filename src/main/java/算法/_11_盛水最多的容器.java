package 算法;


//https://leetcode-cn.com/problems/container-with-most-water/
public class _11_盛水最多的容器 {

    /**
     * 双指针解法。左右两个指针向中间移动，高度低的可以作为桶的一个边。以此判断每条边作为桶的边的情况下盛水的最大值。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int max = 0;
        int lIndex = 0;
        int rIndex = height.length - 1;
        while (lIndex < rIndex){
            if (height[lIndex] <= height[rIndex]) {
                max = Math.max(max, (rIndex - lIndex)*height[lIndex]);
                lIndex++;
            }else {
                max = Math.max(max, (rIndex - lIndex)*height[rIndex]);
                rIndex--;
            }
        }
        return max;
    }
}
