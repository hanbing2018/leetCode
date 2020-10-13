package 剑指offer;


//https://leetcode-cn.com/problems/qiu-12n-lcof/
public class _64_求1到n连续整数的和 {

    /**
     * 属于技巧型的题目，没啥意思
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
