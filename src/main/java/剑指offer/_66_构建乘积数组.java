package 剑指offer;


//https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
public class _66_构建乘积数组 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] c = new int[a.length];
        int[] d = new int[a.length];

        c[0] = 1;
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] * a[i - 1];
        }
        d[d.length - 1] = 1;
        for (int i = d.length - 2; i >= 0; i--) {
            d[i] = d[i + 1] * a[i + 1];
        }

        int[] b = new int[a.length];

        for (int i = 0; i < b.length; i++) {
            b[i] = c[i] * d[i];
        }

        return b;
    }
}
