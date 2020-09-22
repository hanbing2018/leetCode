package 剑指offer;


//https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
public class _39_数组中出现次数超过一半的数字 {

    public int majorityElement(int[] nums) {

        //摩尔投票法,也可以用HashMap,数值为key，出现的数字为value
        int vote = 0;
        int x = nums[0];
        for (int num : nums) {
            if (vote == 0) x = num;
            vote += x == num ? 1 : -1;
        }
        return x;
    }
}
