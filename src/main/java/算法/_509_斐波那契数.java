package 算法;

/**
 * @author hanbing
 * @date 2019-12-30 3:56
 */

//https://leetcode-cn.com/problems/fibonacci-number/
public class _509_斐波那契数 {


    public int fib(int N) {
        if (N<=1) return N;
        int t1 = 0;
        int t2 = 1;
        int ans = -1;

        for (int i=1; i<N; i++){
            ans = t1 + t2;
            t1 = t2;
            t2 = ans;
        }

        return ans;
    }
}
