package 算法;

//https://leetcode-cn.com/problems/three-steps-problem-lcci/
public class _08_01_三步问题 {

    final int MO = 1000000007;

    public int waysToStep(int n) {
        long t1 = 1;
        long t2 = 2;
        long t3 = 4;

        if (n == 1) return (int) t1;
        if (n == 2) return (int) t2;
        if (n == 3) return (int) t3;

        long res = 0;
        for (long i = 4; i <= n; i++) {
            res = t1 + t2 + t3;
            //注意此处有坑，要取模
            res %= MO;
            t1 = t2;
            t2 = t3;
            t3 = res;
        }

        return (int) (res % MO);
    }
}
