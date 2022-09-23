package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-02 14:27
 */

//https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
public class _11_旋转数组中的最小数字 {

    /**
     * 二分查找的变形，时间复杂度为O(logN)
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = left;  //设置mid为最左的数，当数组并未旋转时直接返回left
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) return numbers[right]; //right与left相差1，此时left指向左部分最大值，right指向右部分最小值
            mid = (left + right)/2;
            //如果left、right和mid指向的数值相等，则不能判断最小值的位置，此时要采用顺序查找的方式
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                return minEqual(numbers);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return numbers[mid];
    }

    private int minEqual(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
        }
        return min;
    }
}
