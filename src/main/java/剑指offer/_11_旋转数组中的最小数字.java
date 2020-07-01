package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-02 14:27
 */

//https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
public class _11_旋转数组中的最小数字 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = left;
        while (numbers[left]>=numbers[right]){
            if (right-left == 1) return numbers[right];
            mid = (left + right)/2;
            if (numbers[left]==numbers[mid] && numbers[mid]==numbers[right]){
                return minEqual(numbers);
            }
            if (numbers[mid]>= numbers[left]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return numbers[mid];
    }

    private int minEqual(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i]<min) min = numbers[i];
        }
        return min;
    }
}
