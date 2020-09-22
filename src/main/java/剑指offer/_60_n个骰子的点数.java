package 剑指offer;


//https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
public class _60_n个骰子的点数 {

    public double[] twoSum(int n) {
        //dp算法
        int[][] counts = new int[n + 1][n * 6 + 1];  //int[i][j] 表示i个骰子出现j个点的次数

        //初始化条件
        for (int i = 1; i <= 6; i++) {
            counts[1][i] = 1;
        }

        //递推计算
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) {
                        counts[i][j] += counts[i - 1][j - k];
                    }
                }
            }
        }

        double[] res = new double[n * 6 - n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = counts[n][n + i] / Math.pow(6, n);
        }

        return res;
    }
}
